/*
 * Copyright 2021 Alexey Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.concurrency.core

import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.disposables.DisposableHelper
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable
import io.reactivex.rxjava3.internal.fuseable.QueueFuseable
import java.util.concurrent.atomic.AtomicReference

/**
 * An  extended test Observer that records events and allows making assertions about them.
 *
 *
 * You can override the onSubscribe, onNext, onError, onComplete, onSuccess and
 * cancel methods but not the others (this is by design).
 *
 *
 * The TestObserver implements Disposable for convenience where dispose calls cancel.
 *
 * @param <T> the value type
</T> */
class TestObserverEx<T> @JvmOverloads constructor(downstream: Observer<in T> = EmptyObserver.INSTANCE) :
    BaseTestConsumerEx<T, TestObserverEx<T>?>(),
    Observer<T>,
    Disposable,
    MaybeObserver<T>,
    SingleObserver<T>,
    CompletableObserver {
    /** The actual observer to forward events to.  */
    private val downstream: Observer<in T> = downstream

    /** Holds the current subscription if any.  */
    private val upstream = AtomicReference<Disposable?>()
    private var qd: QueueDisposable<T>? = null

    /**
     * Constructs a TestObserverEx with the given initial fusion mode.
     * @param fusionMode the fusion mode, see [QueueFuseable]
     */
    constructor(fusionMode: Int) : this() {
        setInitialFusionMode(fusionMode)
    }

    override fun onSubscribe(d: Disposable?) {
        lastThread = Thread.currentThread()
        if (d == null) {
            errors.add(NullPointerException("onSubscribe received a null Subscription"))
            return
        }
        if (!upstream.compareAndSet(null, d)) {
            d.dispose()
            if (upstream.get() !== DisposableHelper.DISPOSED) {
                errors.add(IllegalStateException("onSubscribe received multiple subscriptions: $d"))
            }
            return
        }
        if (initialFusionMode != 0) {
            if (d is QueueDisposable<*>) {
                qd = d as QueueDisposable<T>
                val m = qd?.requestFusion(initialFusionMode) ?: 0
                establishedFusionMode = m
                if (m == QueueFuseable.SYNC) {
                    checkSubscriptionOnce = true
                    lastThread = Thread.currentThread()
                    try {
                        var t: T
                        while (qd!!.poll().also { t = it } != null) {
                            values.add(t)
                        }
                        completions++
                        upstream.lazySet(DisposableHelper.DISPOSED)
                    } catch (ex: Throwable) {
                        errors.add(ex)
                    }
                    return
                }
            }
        }
        downstream.onSubscribe(d)
    }

    override fun onNext(t: T) {
        var t: T? = t
        if (!checkSubscriptionOnce) {
            checkSubscriptionOnce = true
            if (upstream.get() == null) {
                errors.add(IllegalStateException("onSubscribe not called in proper order"))
            }
        }
        lastThread = Thread.currentThread()
        if (establishedFusionMode == QueueFuseable.ASYNC) {
            try {
                while (qd!!.poll().also { t = it } != null) {
                    values.add(t)
                }
            } catch (ex: Throwable) {
                errors.add(ex)
                qd!!.dispose()
            }
            return
        }
        values.add(t)
        if (t == null) {
            errors.add(NullPointerException("onNext received a null value"))
        }
        downstream.onNext(t)
    }

    override fun onError(t: Throwable?) {
        if (!checkSubscriptionOnce) {
            checkSubscriptionOnce = true
            if (upstream.get() == null) {
                errors.add(IllegalStateException("onSubscribe not called in proper order"))
            }
        }
        try {
            lastThread = Thread.currentThread()
            if (t == null) {
                errors.add(NullPointerException("onError received a null Throwable"))
            } else {
                errors.add(t)
            }
            downstream.onError(t)
        } finally {
            done.countDown()
        }
    }

    override fun onComplete() {
        if (!checkSubscriptionOnce) {
            checkSubscriptionOnce = true
            if (upstream.get() == null) {
                errors.add(IllegalStateException("onSubscribe not called in proper order"))
            }
        }
        try {
            lastThread = Thread.currentThread()
            completions++
            downstream.onComplete()
        } finally {
            done.countDown()
        }
    }

    override fun dispose() {
        DisposableHelper.dispose(upstream)
    }

    override fun isDisposed(): Boolean {
        return DisposableHelper.isDisposed(upstream.get())
    }
    // state retrieval methods
    /**
     * Returns true if this TestObserver received a subscription.
     * @return true if this TestObserver received a subscription
     */
    fun hasSubscription(): Boolean {
        return upstream.get() != null
    }

    /**
     * Assert that the onSubscribe method was called exactly once.
     * @return this;
     */
    override fun assertSubscribed(): TestObserverEx<T> {
        if (upstream.get() == null) {
            throw fail("Not subscribed!")
        }
        return this
    }

    /**
     * Assert that the onSubscribe method hasn't been called at all.
     * @return this;
     */
    fun assertNotSubscribed(): TestObserverEx<T> {
        if (upstream.get() != null) {
            throw fail("Subscribed!")
        } else if (!errors.isEmpty()) {
            throw fail("Not subscribed but errors found")
        }
        return this
    }

    /**
     * Sets the initial fusion mode if the upstream supports fusion.
     *
     * Package-private: avoid leaking the now internal fusion properties into the public API.
     * Use ObserverFusion to work with such tests.
     * @param mode the mode to establish, see the [QueueDisposable] constants
     * @return this
     */
    private fun setInitialFusionMode(mode: Int): TestObserverEx<T> {
        this.initialFusionMode = mode
        return this
    }

    /**
     * Asserts that the given fusion mode has been established
     *
     * Package-private: avoid leaking the now internal fusion properties into the public API.
     * Use ObserverFusion to work with such tests.
     * @param mode the expected mode
     * @return this
     */
    fun assertFusionMode(mode: Int): TestObserverEx<T> {
        val m: Int = establishedFusionMode
        if (m != mode) {
            if (qd != null) {
                throw AssertionError(
                    "Fusion mode different. Expected: " + fusionModeToString(mode)
                        .toString() + ", actual: " + fusionModeToString(m)
                )
            } else {
                throw fail("Upstream is not fuseable")
            }
        }
        return this
    }

    /**
     * Assert that the upstream is a fuseable source.
     *
     * Package-private: avoid leaking the now internal fusion properties into the public API.
     * Use ObserverFusion to work with such tests.
     * @return this
     */
    fun assertFuseable(): TestObserverEx<T> {
        if (qd == null) {
            throw AssertionError("Upstream is not fuseable.")
        }
        return this
    }

    /**
     * Assert that the upstream is not a fuseable source.
     *
     * Package-private: avoid leaking the now internal fusion properties into the public API.
     * Use ObserverFusion to work with such tests.
     * @return this
     */
    fun assertNotFuseable(): TestObserverEx<T> {
        if (qd != null) {
            throw AssertionError("Upstream is fuseable.")
        }
        return this
    }

    override fun onSuccess(value: T) {
        onNext(value)
        onComplete()
    }

    /**
     * An observer that ignores all events and does not report errors.
     */
    internal enum class EmptyObserver : Observer<Any?> {
        INSTANCE;

        override fun onSubscribe(d: Disposable) {}
        override fun onNext(t: Any?) {}
        override fun onError(t: Throwable) {}
        override fun onComplete() {}
    }
    /**
     * Constructs a forwarding TestObserver.
     * @param downstream the actual Observer to forward events to
     */
}

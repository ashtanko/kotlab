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

import io.reactivex.rxjava3.functions.Predicate
import io.reactivex.rxjava3.internal.fuseable.QueueFuseable
import io.reactivex.rxjava3.internal.util.ExceptionHelper
import io.reactivex.rxjava3.observers.BaseTestConsumer

/**
 * Base class with shared infrastructure to support TestSubscriber and TestObserver.
 * @param <T> the value type consumed
 * @param <U> the subclass of this BaseTestConsumer
</U></T> */
abstract class BaseTestConsumerEx<T, U : BaseTestConsumerEx<T, U>?> : BaseTestConsumer<T, U>() {
    protected var initialFusionMode = 0
    protected var establishedFusionMode = 0

    /**
     * The optional tag associated with this test consumer.
     * @since 2.0.7
     */
    protected var tag: CharSequence? = null

    /**
     * Indicates that one of the awaitX method has timed out.
     * @since 2.0.7
     */
    protected var timeout = false

    /**
     * Returns the last thread which called the onXXX methods of this TestObserver/TestSubscriber.
     * @return the last thread which called the onXXX methods
     */
    fun lastThread(): Thread {
        return lastThread
    }
    // assertion methods
    /**
     * Assert that this TestObserver/TestSubscriber did not receive an onNext value which is equal to
     * the given value with respect to null-safe Object.equals.
     *
     *
     * History: 2.0.5 - experimental
     * @param value the value to expect not being received
     * @return this
     * @since 2.1
     */
    fun assertNever(value: T): U {
        val s = values.size
        for (i in 0 until s) {
            val v = values[i]
            if (v == value) {
                throw fail("Value at position " + i + " is equal to " + valueAndClass(value) + "; Expected them to be different")
            }
        }
        return this as U
    }

    /**
     * Asserts that this TestObserver/TestSubscriber did not receive any onNext value for which
     * the provided predicate returns true.
     *
     *
     * History: 2.0.5 - experimental
     * @param valuePredicate the predicate that receives the onNext value
     * and should return true for the expected value.
     * @return this
     * @since 2.1
     */
    fun assertNever(valuePredicate: Predicate<in T>): U {
        val s = values.size
        for (i in 0 until s) {
            val v = values[i]
            try {
                if (valuePredicate.test(v)) {
                    throw fail("Value at position $i matches predicate $valuePredicate, which was not expected.")
                }
            } catch (ex: Throwable) {
                throw ExceptionHelper.wrapOrThrow(ex)
            }
        }
        return this as U
    }

    /**
     * Assert that the TestObserver/TestSubscriber terminated (i.e., the terminal latch reached zero).
     * @return this
     */
    fun assertTerminated(): U {
        if (done.count != 0L) {
            throw fail("Subscriber still running!")
        }
        val c = completions
        if (c > 1) {
            throw fail("Terminated with multiple completions: $c")
        }
        val s = errors.size
        if (s > 1) {
            throw fail("Terminated with multiple errors: $s")
        }
        if (c != 0L && s != 0) {
            throw fail("Terminated with multiple completions and errors: $c")
        }
        return this as U
    }

    /**
     * Assert that the TestObserver/TestSubscriber has not terminated (i.e., the terminal latch is still non-zero).
     * @return this
     */
    fun assertNotTerminated(): U {
        if (done.count == 0L) {
            throw fail("Subscriber terminated!")
        }
        return this as U
    }

    /**
     * Assert that there is a single error and it has the given message.
     * @param message the message expected
     * @return this
     */
    fun assertErrorMessage(message: String): U {
        val s = errors.size
        if (s == 0) {
            throw fail("No errors")
        } else if (s == 1) {
            val e = errors[0]
            val errorMessage = e.message
            if (message != errorMessage) {
                throw fail("Error message differs; exptected: $message but was: $errorMessage")
            }
        } else {
            throw fail("Multiple errors")
        }
        return this as U
    }

    /**
     * Assert that the upstream signalled the specified values in order and then failed
     * with a Throwable for which the provided predicate returns true.
     * @param errorPredicate
     * the predicate that receives the error Throwable
     * and should return true for expected errors.
     * @param values the expected values, asserted in order
     * @return this
     */
    @SafeVarargs
    fun assertFailure(errorPredicate: Predicate<Throwable>, vararg values: T): U? {
        return assertSubscribed()?.assertValues(*values)?.assertError(errorPredicate)?.assertNotComplete()
    }

    /**
     * Assert that the upstream signalled the specified values in order,
     * then failed with a specific class or subclass of Throwable
     * and with the given exact error message.
     * @param error the expected exception (parent) class
     * @param message the expected failure message
     * @param values the expected values, asserted in order
     * @return this
     */
    @SafeVarargs
    fun assertFailureAndMessage(
        error: Class<out Throwable?>?,
        message: String?,
        vararg values: T
    ): U? {
        return assertSubscribed()
            ?.assertValues(*values)
            ?.assertError(error)
            ?.assertErrorMessage(message!!)
            ?.assertNotComplete()
    }

    /**
     * Returns true if an await timed out.
     * @return true if one of the timeout-based await methods has timed out.
     *
     * History: 2.0.7 - experimental
     * @see .clearTimeout
     * @see .assertTimeout
     * @see .assertNoTimeout
     * @since 2.1
     */
    fun isTimeout(): Boolean {
        return timeout
    }

    /**
     * Clears the timeout flag set by the await methods when they timed out.
     *
     * History: 2.0.7 - experimental
     * @return this
     * @since 2.1
     * @see .isTimeout
     */
    fun clearTimeout(): U {
        timeout = false
        return this as U
    }

    /**
     * Asserts that some awaitX method has timed out.
     *
     * History: 2.0.7 - experimental
     * @return this
     * @since 2.1
     */
    fun assertTimeout(): U {
        if (!timeout) {
            throw fail("No timeout?!")
        }
        return this as U
    }

    /**
     * Asserts that some awaitX method has not timed out.
     *
     * History: 2.0.7 - experimental
     * @return this
     * @since 2.1
     */
    fun assertNoTimeout(): U {
        if (timeout) {
            throw fail("Timeout?!")
        }
        return this as U
    }

    /**
     * Returns the internal shared list of errors.
     * @return Returns the internal shared list of errors.
     */
    fun errors(): List<Throwable> {
        return errors
    }

    /**
     * Returns true if this test consumer has terminated in any fashion.
     * @return true if this test consumer has terminated in any fashion
     */
    val isTerminated: Boolean
        get() = done.count == 0L

    /**
     * Returns the number of times onComplete() was called.
     * @return the number of times onComplete() was called
     */
    fun completions(): Long {
        return completions
    }

    /**
     * Fail with the given message and add the sequence of errors as suppressed ones.
     *
     * Note this is deliberately the only fail method. Most of the times an assertion
     * would fail but it is possible it was due to an exception somewhere. This construct
     * will capture those potential errors and report it along with the original failure.
     *
     * @param message the message to use
     * @return AssertionError the prepared AssertionError instance
     */
    fun failWith(message: String?): AssertionError {
        return fail(message)
    }

    companion object {
        fun fusionModeToString(mode: Int): String {
            return when (mode) {
                QueueFuseable.NONE -> "NONE"
                QueueFuseable.SYNC -> "SYNC"
                QueueFuseable.ASYNC -> "ASYNC"
                else -> "Unknown($mode)"
            }
        }
    }
}

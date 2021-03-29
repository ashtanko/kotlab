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

package dev.shtanko.concurrency

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference

open class TestBase {
    private var actionIndex = AtomicInteger()
    private var finished = AtomicBoolean()
    private var error = AtomicReference<Throwable>()

    fun expect(index: Int) {
        val wasIndex = actionIndex.incrementAndGet()
        check(index == wasIndex) { "Expecting action index $index but it is actually $wasIndex" }
    }

    fun runTest(
        block: suspend CoroutineScope.() -> Unit
    ) {
        runBlocking(block = block)
    }

    private inline fun check(value: Boolean, lazyMessage: () -> Any) {
        if (!value) error(lazyMessage())
    }

    private fun error(message: Any, cause: Throwable? = null): Nothing {
        throw makeError(message, cause)
    }

    private fun setError(exception: Throwable) {
        error.compareAndSet(null, exception)
    }

    private fun makeError(message: Any, cause: Throwable? = null): IllegalStateException =
        IllegalStateException(message.toString(), cause).also {
            setError(it)
        }
}

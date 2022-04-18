/*
 * Copyright 2021 Oleksii Shtanko
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

package dev.shtanko.concurrency.coroutines.mutex

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.system.measureTimeMillis

class Counter {

    private val mutex = Mutex()
    private var count = 0

    suspend fun inc() {
        mutex.withLock {
            count++
        }
    }

    suspend fun dec() {
        mutex.withLock {
            count--
        }
    }

    fun value() = count
}

/**
 * @param nCoroutines number of coroutines to launch
 * @param times times an action is repeated by each coroutine
 */
suspend fun massiveRun(nCoroutines: Int = 100, times: Int = 1000, action: suspend () -> Unit) {
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(nCoroutines) {
                launch {
                    repeat(times) { action() }
                }
            }
        }
    }
    println("Completed ${nCoroutines * times} actions in $time ms")
}

/*
 * Copyright 2024 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.concurrency

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class CounterMutex {
    private val mutex = Mutex()
    private var value = 0

    // Increment the counter value
    suspend fun inc() {
        mutex.withLock {
            value++
        }
    }

    // Get the current counter value
    fun value(): Int = value
}

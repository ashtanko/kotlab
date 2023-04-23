/*
 * Copyright 2023 Oleksii Shtanko
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

package dev.shtanko.collections.concurrent

import java.util.concurrent.ConcurrentLinkedDeque
import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import org.jetbrains.kotlinx.lincheck.verifier.VerifierState

class ConcurrentLinkedDequeTest : VerifierState() {
    private val deque = ConcurrentLinkedDeque<Int>()

    @Operation
    fun addFirst(value: Int) = deque.addFirst(value)

    @Operation
    fun addLast(value: Int) = deque.addLast(value)

    @Operation
    fun getFirst() = deque.peekFirst()

    @Operation // this operation is non-linearizable!
    fun getLast() = deque.peekLast()

    @Operation
    fun pollFirst() = deque.pollFirst()

    @Operation
    fun pollLast() = deque.pollLast()

    override fun extractState() = deque.toList()

    // @Test
    fun runModelCheckingTest() = StressOptions()
        .check(ConcurrentLinkedDequeTest::class)
}

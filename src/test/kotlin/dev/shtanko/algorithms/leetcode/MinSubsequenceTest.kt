/*
 * Copyright 2020 Oleksii Shtanko
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

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class AbstractMinSubsequenceStrategyTest<T : MinSubsequenceStrategy>(val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<List<Int>, IntArray>> {
            return listOf(
                listOf(10, 9) to intArrayOf(4, 3, 10, 9, 8),
                listOf(7, 7, 6) to intArrayOf(4, 4, 7, 6, 7),
                listOf(6) to intArrayOf(6),
                listOf(1, 1, 1) to intArrayOf(1, 1, 1, 1, 1),
                listOf(5, 3) to intArrayOf(1, 1, 1, 1, 1, 3, 5)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `min subsequence test`(testCase: Pair<List<Int>, IntArray>) {
        val (expected, arr) = testCase
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

internal class MinSubsequenceCountingSortTest :
    AbstractMinSubsequenceStrategyTest<MinSubsequenceCountingSort>(MinSubsequenceCountingSort())

internal class MinSubsequencePriorityQueueTest :
    AbstractMinSubsequenceStrategyTest<MinSubsequencePriorityQueue>(MinSubsequencePriorityQueue())

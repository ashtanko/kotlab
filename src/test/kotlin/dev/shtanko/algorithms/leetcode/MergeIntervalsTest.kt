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

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class MergeIntervalsStrategyTest<out T : MergeIntervalsStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Array<IntArray>, Array<IntArray>>> {
            return listOf(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18),
                ) to arrayOf(
                    intArrayOf(1, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18),
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `merge intervals test`(testCase: Pair<Array<IntArray>, Array<IntArray>>) {
        val (intervals, expected) = testCase
        val actual = strategy.perform(intervals)
        assertArrayEquals(expected, actual)
    }
}

internal class MergeIntervalsConnectedComponentsTest :
    MergeIntervalsStrategyTest<MergeIntervalsConnectedComponents>(MergeIntervalsConnectedComponents())

internal class MergeIntervalsSortingTest :
    MergeIntervalsStrategyTest<MergeIntervalsSorting>(MergeIntervalsSorting())

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

internal abstract class AbstractLuckyNumbersStrategyTest<out T : AbstractLuckyNumbersStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Array<IntArray>, List<Int>>> {
            return listOf(
                arrayOf(
                    intArrayOf(3, 7, 8),
                    intArrayOf(9, 11, 13),
                    intArrayOf(15, 16, 17)
                ) to listOf(15),
                arrayOf(
                    intArrayOf(1, 10, 4, 2),
                    intArrayOf(9, 3, 8, 7),
                    intArrayOf(15, 16, 17, 12)
                ) to listOf(12),
                arrayOf(
                    intArrayOf(7, 8),
                    intArrayOf(1, 2)
                ) to listOf(7),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple test`(testCase: Pair<Array<IntArray>, List<Int>>) {
        val (matrix, expected) = testCase
        assertEquals(expected, strategy.perform(matrix))
    }
}

internal class LuckyNumbersTest : AbstractLuckyNumbersStrategyTest<LuckyNumbers>(LuckyNumbers())

internal class LuckyNumbersSetTest : AbstractLuckyNumbersStrategyTest<LuckyNumbersSet>(LuckyNumbersSet())

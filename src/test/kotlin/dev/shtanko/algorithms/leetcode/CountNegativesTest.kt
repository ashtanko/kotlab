/*
 * Copyright 2020 Alexey Shtanko
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

internal abstract class AbstractCountNegativesTest<out T : AbstractCountNegativesStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Array<IntArray>>> {
            return listOf(
                8 to arrayOf(
                    intArrayOf(4, 3, 2, -1),
                    intArrayOf(3, 2, 1, -1),
                    intArrayOf(1, 1, -1, -2),
                    intArrayOf(-1, -1, -2, -3)
                ),
                0 to arrayOf(
                    intArrayOf(3, 2),
                    intArrayOf(1, 0)
                ),
                3 to arrayOf(
                    intArrayOf(1, -1),
                    intArrayOf(-1, -1)
                ),
                1 to arrayOf(
                    intArrayOf(-1)
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `count negatives test`(testCase: Pair<Int, Array<IntArray>>) {
        val (expected, grid) = testCase
        val actual = strategy.perform(grid)
        assertEquals(expected, actual)
    }
}

internal class SimpleCountNegativesTest : AbstractCountNegativesTest<SimpleCountNegatives>(SimpleCountNegatives())

internal class CountNegativesTwoPointersTest :
    AbstractCountNegativesTest<CountNegativesTwoPointers>(CountNegativesTwoPointers())

internal class CountNegativesBinaryTest : AbstractCountNegativesTest<CountNegativesBinary>(CountNegativesBinary())

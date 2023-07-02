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

class SpiralMatrixTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Array<IntArray>, List<Int>>> {
            return listOf(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9),
                ) to listOf(1, 2, 3, 6, 9, 8, 7, 4, 5),
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12),
                ) to listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12),
                    intArrayOf(13, 14, 15, 16),
                ) to listOf(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `spiral order test`(testCase: Pair<Array<IntArray>, List<Int>>) {
        val (matrix, expected) = testCase
        val actual = matrix.spiralOrder()
        assertEquals(expected, actual)
    }
}

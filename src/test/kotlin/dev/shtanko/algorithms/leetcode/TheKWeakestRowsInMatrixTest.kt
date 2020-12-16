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

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class TheKWeakestRowsInMatrixTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Array<IntArray>, Int>, IntArray>> {
            return listOf(
                arrayOf(
                    intArrayOf(1, 1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 0),
                    intArrayOf(1, 0, 0, 0, 0),
                    intArrayOf(1, 1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1)
                ) to 3 to intArrayOf(2, 0, 3),
                arrayOf(
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(1, 0, 0, 0)
                ) to 2 to intArrayOf(0, 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `kWeakest rows test`(testCase: Pair<Pair<Array<IntArray>, Int>, IntArray>) {
        val (pair, expected) = testCase
        val (matrix, k) = pair
        val data = matrix to k
        val actual = data.kWeakestRows()
        assertArrayEquals(expected, actual)
    }
}

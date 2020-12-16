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

internal class FlipAndInvertImageTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Array<IntArray>, Array<IntArray>>> {
            return listOf(
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, 0, 0)
                ) to arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 1, 1)
                ),
                arrayOf(
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(1, 0, 0, 1),
                    intArrayOf(0, 1, 1, 1),
                    intArrayOf(1, 0, 1, 0)
                ) to arrayOf(
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(1, 0, 1, 0)
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `flip and invert image test`(testCase: Pair<Array<IntArray>, Array<IntArray>>) {
        val (arr, expected) = testCase
        val actual = flipAndInvertImage(arr)
        assertArrayEquals(expected, actual)
    }
}

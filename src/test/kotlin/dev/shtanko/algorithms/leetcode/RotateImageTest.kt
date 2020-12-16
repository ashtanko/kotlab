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

internal class RotateImageTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Array<IntArray>, Array<IntArray>>> {
            return listOf(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ) to arrayOf(
                    intArrayOf(7, 4, 1),
                    intArrayOf(8, 5, 2),
                    intArrayOf(9, 6, 3)
                ),
                arrayOf(
                    intArrayOf(5, 1, 9, 11),
                    intArrayOf(2, 4, 8, 10),
                    intArrayOf(13, 3, 6, 7),
                    intArrayOf(15, 14, 12, 16)
                ) to arrayOf(
                    intArrayOf(15, 13, 2, 5),
                    intArrayOf(14, 3, 4, 1),
                    intArrayOf(12, 6, 8, 9),
                    intArrayOf(16, 7, 10, 11)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `rotate image test`(testCase: Pair<Array<IntArray>, Array<IntArray>>) {
        val (arr, expected) = testCase
        arr.rotateImage()
        assertArrayEquals(expected, arr)
    }
}

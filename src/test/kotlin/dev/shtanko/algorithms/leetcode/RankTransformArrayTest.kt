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

internal class RankTransformArrayTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(40, 10, 20, 30) to intArrayOf(4, 1, 2, 3),
                intArrayOf(100, 100, 100) to intArrayOf(1, 1, 1),
                intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12) to intArrayOf(5, 3, 4, 2, 8, 6, 7, 1, 3),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `array rank transform test`(testCase: Pair<IntArray, IntArray>) {
        val (arr, expected) = testCase
        val actual = arr.arrayRankTransform()
        assertArrayEquals(expected, actual)
    }
}

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

internal class SmallerNumbersThanCurrentTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(8, 1, 2, 2, 3) to intArrayOf(4, 0, 1, 1, 3),
                intArrayOf(6, 5, 4, 8) to intArrayOf(2, 1, 0, 3),
                intArrayOf(7, 7, 7, 7) to intArrayOf(0, 0, 0, 0)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `smaller numbers than current test`(testCase: Pair<IntArray, IntArray>) {
        val (arr, expected) = testCase
        val actual = arr.smallerNumbersThanCurrent()
        assertArrayEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `smaller numbers than current naive test`(testCase: Pair<IntArray, IntArray>) {
        val (arr, expected) = testCase
        val actual = arr.smallerNumbersThanCurrentNaive()
        assertArrayEquals(expected, actual)
    }
}

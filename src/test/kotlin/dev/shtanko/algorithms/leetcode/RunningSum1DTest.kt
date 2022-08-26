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
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class RunningSum1DTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf() to intArrayOf(),
                intArrayOf(1, 2, 3, 4) to intArrayOf(1, 3, 6, 10),
                intArrayOf(1, 1, 1, 1, 1) to intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(3, 1, 2, 10, 1) to intArrayOf(3, 4, 6, 16, 17),
                intArrayOf(-3, 1, -2, 10, -1) to intArrayOf(-3, -2, -4, 6, 5),
            )
        }
    }

    @Test
    internal fun `is empty test`() {
        val arr = intArrayOf()
        assertTrue(arr.runningSumNaive().isEmpty())
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `running sum naive test`(testCase: Pair<IntArray, IntArray>) {
        val (arr, expected) = testCase
        val actual = arr.runningSumNaive()
        assertArrayEquals(expected, actual)
    }
}

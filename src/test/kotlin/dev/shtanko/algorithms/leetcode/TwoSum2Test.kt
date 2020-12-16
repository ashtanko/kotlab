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

internal class TwoSum2Test {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, IntArray>> {
            return listOf(
                intArrayOf(2, 7, 11, 15) to 9 to intArrayOf(1, 2),
                intArrayOf(4, 8, 15, 16, 23, 42) to 16 to intArrayOf(2, 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `two sum 2 test`(testCase: Pair<Pair<IntArray, Int>, IntArray>) {
        val (data, expected) = testCase
        val (arr, target) = data
        val actual = arr.twoSum2(target)
        assertArrayEquals(expected, actual)
    }
}

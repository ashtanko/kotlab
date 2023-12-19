/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
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

class ShuffleArrayTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, IntArray>> {
            return listOf(
                Pair(Pair(intArrayOf(2, 5, 1, 3, 4, 7), 3), intArrayOf(2, 3, 5, 4, 1, 7)),
                Pair(Pair(intArrayOf(1, 2, 3, 4, 4, 3, 2, 1), 4), intArrayOf(1, 4, 2, 3, 3, 2, 4, 1)),
                Pair(Pair(intArrayOf(1, 1, 2, 2), 2), intArrayOf(1, 2, 1, 2)),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `shuffle test`(testCase: Pair<Pair<IntArray, Int>, IntArray>) {
        val (data, expected) = testCase
        val (arr, n) = data
        val actual = arr.shuffle(n)
        assertArrayEquals(expected, actual)
    }
}

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

class RelativeSortArrayTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, IntArray>, IntArray>> {
            return listOf(
                intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19)
                    to intArrayOf(2, 1, 4, 3, 9, 6)
                    to intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19),
                intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19) to
                    intArrayOf(2, 1, 4, 3, 9, 6) to
                    intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `relative sort array test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val (pair, expected) = testCase
        val actual = pair.relativeSortArray()
        assertArrayEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `relative sort array using tree test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val (pair, expected) = testCase
        val actual = pair.relativeSortArrayTree()
        assertArrayEquals(expected, actual)
    }
}

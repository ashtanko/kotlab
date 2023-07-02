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

class DuplicateZerosTest {
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(1, 0, 2, 3, 0, 4, 5, 0) to intArrayOf(1, 0, 0, 2, 3, 0, 0, 4),
                intArrayOf(1, 2, 3) to intArrayOf(1, 2, 3),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `duplicate zeros test`(testCase: Pair<IntArray, IntArray>) {
        val (arr, expected) = testCase
        duplicateZeros(arr)
        assertArrayEquals(expected, arr)
    }
}

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

class FairCandySwapTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, IntArray>, IntArray>> {
            return listOf(
                intArrayOf() to intArrayOf() to intArrayOf(),
                intArrayOf(1, 1) to intArrayOf(2, 2) to intArrayOf(1, 2),
                intArrayOf(1, 2) to intArrayOf(2, 3) to intArrayOf(1, 2),
                intArrayOf(2) to intArrayOf(1, 3) to intArrayOf(2, 3),
                intArrayOf(1, 2, 5) to intArrayOf(2, 4) to intArrayOf(5, 4),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `fair candy swap test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val (candies, expected) = testCase
        val actual = candies.fairCandySwap()
        assertArrayEquals(expected, actual)
    }
}

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

internal abstract class TwoSumTest<out T : TwoSumStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, IntArray>> {
            return listOf(
                intArrayOf(4, 8, 15, 16, 23) to 9 to intArrayOf(),
                intArrayOf(4, 8, 15, 16, 23) to 12 to intArrayOf(0, 1),
                intArrayOf(4, 8, 15, 16, 23) to 39 to intArrayOf(3, 4)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `two sum test`(testCase: Pair<Pair<IntArray, Int>, IntArray>) {
        val (data, expected) = testCase
        val (array, target) = data
        val actual = strategy.perform(array, target)
        assertArrayEquals(expected, actual)
    }
}

internal class TwoSumBruteForceTest : TwoSumTest<TwoSumBruteForce>(TwoSumBruteForce())
internal class TwoSumTwoPassHashTableTest : TwoSumTest<TwoSumTwoPassHashTable>(TwoSumTwoPassHashTable())
internal class TwoSumOnePassHashTableTest : TwoSumTest<TwoSumOnePassHashTable>(TwoSumOnePassHashTable())

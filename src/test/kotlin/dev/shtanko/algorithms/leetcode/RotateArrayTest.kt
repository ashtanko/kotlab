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

internal abstract class AbstractRotateArrayStrategyTest<out T : AbstractRotateArrayStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, IntArray>> {
            return listOf(
                Pair(Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3), intArrayOf(5, 6, 7, 1, 2, 3, 4)),
                Pair(Pair(intArrayOf(-1, -100, 3, 99), 2), intArrayOf(3, 99, -1, -100))
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `rotate array test`(testCase: Pair<Pair<IntArray, Int>, IntArray>) {
        val (data, expected) = testCase
        val (arr, k) = data
        strategy.perform(arr, k)
        assertArrayEquals(expected, arr)
    }
}

internal class RotateArrayBruteForceTest :
    AbstractRotateArrayStrategyTest<RotateArrayBruteForce>(RotateArrayBruteForce())

internal class RotateArrayUsingExtraArrayTest :
    AbstractRotateArrayStrategyTest<RotateArrayUsingExtraArray>(RotateArrayUsingExtraArray())

internal class RotateArrayUsingCyclicReplacementsTest :
    AbstractRotateArrayStrategyTest<RotateArrayUsingCyclicReplacements>(RotateArrayUsingCyclicReplacements())

internal class RotateArrayUsingReverseTest :
    AbstractRotateArrayStrategyTest<RotateArrayUsingReverse>(RotateArrayUsingReverse())

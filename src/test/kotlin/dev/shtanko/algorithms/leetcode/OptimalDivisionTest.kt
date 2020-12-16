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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class OptimalDivisionTest<out T : OptimalDivisionStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<IntArray, String>> {
            return listOf(
                intArrayOf(1000, 100, 10, 2) to "1000/(100/10/2)"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `optimal division test`(testCase: Pair<IntArray, String>) {
        val (nums, expected) = testCase
        val actual = strategy.perform(nums)
        assertEquals(expected, actual)
    }
}

internal class OptimalDivisionBruteForceTest :
    OptimalDivisionTest<OptimalDivisionBruteForce>(OptimalDivisionBruteForce())

internal class OptimalDivisionMemorizationTest :
    OptimalDivisionTest<OptimalDivisionMemorization>(OptimalDivisionMemorization())

internal class MathOptimalDivisionTest : OptimalDivisionTest<MathOptimalDivision>(MathOptimalDivision())

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

internal abstract class CountPrimesTest<out T : CountPrimesStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                0 to 0,
                1 to 0,
                3 to 1,
                4 to 2,
                5 to 2,
                7 to 3,
                11 to 4,
                10 to 4,
                13 to 5,
                1_000_000 to 78498,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple test`(testCase: Pair<Int, Int>) {
        val (n, expected) = testCase
        val actual = strategy.perform(n)
        assertEquals(expected, actual)
    }
}

internal class CountPrimesBrutForceTest : CountPrimesTest<CountPrimesBrutForce>(CountPrimesBrutForce())

internal class CountPrimesTimeComplexityTest : CountPrimesTest<CountPrimesTimeComplexity>(CountPrimesTimeComplexity())

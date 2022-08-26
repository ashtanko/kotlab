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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class SuperEggDropStrategyTest<out T : SuperEggDropStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Pair<Int, Int>>> {
            return listOf(
                3 to (2 to 6),
                4 to (3 to 14),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `super egg drop test`(testCase: Pair<Int, Pair<Int, Int>>) {
        val (expected, data) = testCase
        val (eggs, floors) = data
        val actual = strategy.perform(eggs, floors)
        assertEquals(expected, actual)
    }
}

internal class SuperEggDropDPBinarySearchTest :
    SuperEggDropStrategyTest<SuperEggDropDPBinarySearch>(SuperEggDropDPBinarySearch())

internal class SuperEggDropDPOptimalityCriterionTest :
    SuperEggDropStrategyTest<SuperEggDropDPOptimalityCriterion>(SuperEggDropDPOptimalityCriterion())

internal class SuperEggDropMathematicalTest :
    SuperEggDropStrategyTest<SuperEggDropMathematical>(SuperEggDropMathematical())

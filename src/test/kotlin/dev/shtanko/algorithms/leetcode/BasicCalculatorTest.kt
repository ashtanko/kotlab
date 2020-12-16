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

internal abstract class BasicCalculatorTest<out T : CalculationStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                "1 + 1" to 2,
                " 2-1 + 2 " to 3,
                "(1+(4+5+2)-3)+(6+8)" to 23,
                "2   +2" to 4,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `calculator test`(testCase: Pair<String, Int>) {
        val (s, expected) = testCase
        val actual = strategy.calculate(s)
        assertEquals(expected, actual)
    }
}

internal class StackAndStringReversalTest : BasicCalculatorTest<StackAndStringReversal>(StackAndStringReversal())

internal class StackAndNoStringReversalTest : BasicCalculatorTest<StackAndNoStringReversal>(StackAndNoStringReversal())

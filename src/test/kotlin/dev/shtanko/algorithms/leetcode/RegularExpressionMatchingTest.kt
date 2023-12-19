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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class RegularExpressionMatchingStrategyTest<out T : RegularExpressionMatchStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, String>, Boolean>> {
            return listOf(
                "aa" to "a" to false,
                "aa" to "a*" to true,
                "ab" to ".*" to true,
                "aab" to "c*a*b" to true,
                "mississippi" to "mis*is*p*." to false,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `regular expression matching test`(testCase: Pair<Pair<String, String>, Boolean>) {
        val (data, expected) = testCase
        val (text, pattern) = data
        val actual = strategy.invoke(text = text, pattern = pattern)
        assertEquals(expected, actual)
    }
}

class RegularExpressionMatchRecursionTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchRecursion>(RegularExpressionMatchRecursion())

class RegularExpressionMatchDPTopDownTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchDPTopDown>(RegularExpressionMatchDPTopDown())

class RegularExpressionMatchDPBottomUpTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchDPBottomUp>(RegularExpressionMatchDPBottomUp())

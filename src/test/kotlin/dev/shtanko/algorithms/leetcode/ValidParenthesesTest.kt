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

import java.util.TreeMap
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ValidParenthesesTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, String>> {
            return listOf(
                true to "()",
                true to "()[]{}",
                false to "(]",
                false to "([)]",
                true to "{[]}",
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `is valid parentheses test`(testCase: Pair<Boolean, String>) {
        val (expected, str) = testCase
        val actual = str.isValidParentheses()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `is valid parentheses mapping test`(testCase: Pair<Boolean, String>) {
        val (expected, s) = testCase
        val actual = ValidParentheses(TreeMap()).invoke(s)
        assertEquals(expected, actual)
    }
}

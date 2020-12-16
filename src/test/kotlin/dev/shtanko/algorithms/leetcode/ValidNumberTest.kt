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

internal class ValidNumberTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, String>> {
            return listOf(
                true to "0",
                true to " 0.1 ",
                false to "abc",
                false to "1 a",
                true to "2e10",
                true to " -90e3   ",
                false to " 1e",
                false to "e3",
                true to " 6e-1",
                false to " 99e2.5 ",
                true to "53.5e93",
                false to " --6 ",
                false to "-+3",
                false to "95a54e53",
                true to "-1"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is number using regex test`(testCase: Pair<Boolean, String>) {
        val (expected, str) = testCase
        val actual = str.isNumberRegex()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is number test`(testCase: Pair<Boolean, String>) {
        val (expected, str) = testCase
        val actual = str.isNumber()
        assertEquals(expected, actual)
    }
}

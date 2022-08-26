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

internal class PalindromeNumberTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, Boolean>> {
            return listOf(
                4815 to false,
                121 to true,
                -121 to false,
                0 to true,
                Int.MAX_VALUE to false,
                444 to true,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `is number palindrome test`(testCase: Pair<Int, Boolean>) {
        val (num, expected) = testCase
        val actual = num.isPalindrome()
        assertEquals(expected, actual)
    }
}

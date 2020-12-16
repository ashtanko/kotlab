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

internal class IntegerToEnglishWordsTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, String>> {
            return listOf(
                0 to "Zero",
                1 to "One",
                22 to "Twenty Two",
                123 to "One Hundred Twenty Three",
                444 to "Four Hundred Forty Four",
                12_345 to "Twelve Thousand Three Hundred Forty Five",
                1_234_567 to "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
                1_234_567_891 to "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `integer to English words test`(testCase: Pair<Int, String>) {
        val (num, expected) = testCase
        val actual = IntegerToEnglishWords().numberToWords(num)
        assertEquals(expected, actual)
    }
}

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

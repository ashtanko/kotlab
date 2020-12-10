package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class LongestPalindromeTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, String>> {
            return listOf(
                "babad" to "bab",
                "cbbd" to "bb",
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple test`(testCase: Pair<String, String>) {
        val (str, expected) = testCase
        val actual = str.longestPalindrome()
        assertEquals(expected, actual)
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LongestPalindromeTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, String>> {
            return listOf(
                "babad" to "bab",
                "cbbd" to "bb"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<String, String>) {
        val actual = testCase.first.longestPalindrome()
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}

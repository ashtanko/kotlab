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
                444 to true
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

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromeTest {

    @Test
    fun `simple test`() {
        assertEquals("bab", "babad".longestPalindrome())
    }

    @Test
    fun `simple test 2`() {
        assertEquals("bb", "cbbd".longestPalindrome())
    }
}

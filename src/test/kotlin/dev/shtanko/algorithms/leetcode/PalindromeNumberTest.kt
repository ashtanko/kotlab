package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PalindromeNumberTest {

    @Test
    fun `number is not a palindrome test`() {
        assertFalse(4815.isPalindrome())
    }

    @Test
    fun `number is a palindrome test`() {
        assertTrue(121.isPalindrome())
    }
}

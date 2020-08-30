package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindClosestPalindromeTest {

    @Test
    fun `simple test`() {
        assertEquals("121", "123".nearestPalindromic())
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsSubsequenceTest {

    @Test
    fun `simple test`() {
        assertTrue(isSubsequence("abc", "ahbgdc"))
    }

    @Test
    fun `simple test 2`() {
        assertFalse(isSubsequence("axc", "ahbgdc"))
    }
}

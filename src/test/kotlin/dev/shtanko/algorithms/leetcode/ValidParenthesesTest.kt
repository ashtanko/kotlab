package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidParenthesesTest {

    @Test
    fun `simple test`() {
        assertTrue("()".isValidParentheses())
    }

    @Test
    fun `simple test 2`() {
        assertTrue("()[]{}".isValidParentheses())
    }

    @Test
    fun `simple test 3`() {
        assertFalse("(]".isValidParentheses())
    }

    @Test
    fun `simple test 4`() {
        assertFalse("([)]".isValidParentheses())
    }

    @Test
    fun `simple test 5`() {
        assertTrue("{[]}".isValidParentheses())
    }
}

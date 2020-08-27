package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveOutermostParenthesesTest {

    @Test
    fun `simple test`() {
        assertEquals("()()()", "(()())(())".removeOuterParentheses())
    }

    @Test
    fun `simple test 2`() {
        assertEquals("", "()()".removeOuterParentheses())
    }

    @Test
    fun `simple test 3`() {
        assertEquals("()()()", "(()())(())".removeOuterParentheses2())
    }

    @Test
    fun `simple test 4`() {
        assertEquals("", "()()".removeOuterParentheses2())
    }
}

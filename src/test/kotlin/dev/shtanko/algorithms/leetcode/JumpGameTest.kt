package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class JumpGameTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(2, 3, 1, 1, 4)
        val actual = arr.canJump()
        assertTrue(actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(3, 2, 1, 0, 4)
        val actual = arr.canJump()
        assertFalse(actual)
    }
}

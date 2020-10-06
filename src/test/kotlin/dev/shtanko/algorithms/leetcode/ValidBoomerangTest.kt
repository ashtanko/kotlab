package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidBoomerangTest {

    @Test
    fun `when is boomerang`() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 3),
            intArrayOf(3, 2)
        )
        assertTrue(isBoomerang(points))
    }

    @Test
    fun `when is not boomerang`() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3)
        )
        assertFalse(isBoomerang(points))
    }
}

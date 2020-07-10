package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CanMakeArithmeticProgressionTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(3, 5, 1)
        val actual = arr.canMakeArithmeticProgression()
        assertTrue(actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 2, 4)
        val actual = arr.canMakeArithmeticProgression()
        assertFalse(actual)
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(3, 5, 1)
        val actual = arr.canMakeArithmeticProgressionSet()
        assertTrue(actual)
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(1, 2, 4)
        val actual = arr.canMakeArithmeticProgressionSet()
        assertFalse(actual)
    }

    @Test
    fun `simple test 5`() {
        val arr = intArrayOf(0, 1, 4, 9, 16, 25, 36)
        val actual = arr.canMakeArithmeticProgressionSet()
        assertFalse(actual)
    }

    @Test
    fun `simple test 6`() {
        val arr = intArrayOf(0, 1, 4, 9, 16, 25, 36)
        val actual = arr.canMakeArithmeticProgression()
        assertFalse(actual)
    }
}

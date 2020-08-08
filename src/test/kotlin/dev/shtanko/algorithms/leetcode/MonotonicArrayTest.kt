package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MonotonicArrayTest {

    @Test
    fun `simple test`() {
        assertTrue(intArrayOf(1, 2, 2, 3).isMonotonic())
    }

    @Test
    fun `simple test 2`() {
        assertTrue(intArrayOf(6, 5, 4, 4).isMonotonic())
    }

    @Test
    fun `simple test 3`() {
        assertFalse(intArrayOf(1, 3, 2).isMonotonic())
    }

    @Test
    fun `simple test 4`() {
        assertTrue(intArrayOf(1, 2, 4, 5).isMonotonic())
    }

    @Test
    fun `simple test 5`() {
        assertTrue(intArrayOf(1, 1, 1).isMonotonic())
    }
}

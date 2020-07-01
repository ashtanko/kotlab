package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxProductTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(3, 4, 5, 2)
        assertEquals(12, arr.maxProduct())
    }

    @Test
    fun `simple test 1`() {
        val arr = intArrayOf(1, 5, 4, 5)
        assertEquals(16, arr.maxProduct())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(3, 7)
        assertEquals(12, arr.maxProduct())
    }
}

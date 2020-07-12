package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinStartValueTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(-3, 2, -3, 4, 2)
        assertEquals(5, arr.findMinStartValue())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 2)
        assertEquals(1, arr.findMinStartValue())
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(1, -2, -3)
        assertEquals(5, arr.findMinStartValue())
    }
}

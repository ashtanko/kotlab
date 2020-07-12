package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HeightCheckerTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 1, 4, 2, 1, 3)
        assertEquals(3, arr.heightCheckerSort())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(5, 1, 2, 3, 4)
        assertEquals(5, arr.heightCheckerSort())
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(0, arr.heightCheckerSort())
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(1, 1, 4, 2, 1, 3)
        assertEquals(3, arr.heightChecker())
    }

    @Test
    fun `simple test 5`() {
        val arr = intArrayOf(5, 1, 2, 3, 4)
        assertEquals(5, arr.heightChecker())
    }

    @Test
    fun `simple test 6`() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(0, arr.heightChecker())
    }
}

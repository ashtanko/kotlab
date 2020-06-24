package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RunningSum1DTest {

    @Test
    fun `empty test`() {
        val arr = intArrayOf()
        assertTrue(arr.runningSumNaive().isEmpty())
    }

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 2, 3, 4)
        val expected = intArrayOf(1, 3, 6, 10)
        assertArrayEquals(expected, arr.runningSumNaive())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 1, 1, 1, 1)
        val expected = intArrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(expected, arr.runningSumNaive())
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(3, 1, 2, 10, 1)
        val expected = intArrayOf(3, 4, 6, 16, 17)
        assertArrayEquals(expected, arr.runningSumNaive())
    }

    @Test
    fun `negative numbers test`() {
        val arr = intArrayOf(-3, 1, -2, 10, -1)
        val expected = intArrayOf(-3, -2, -4, 6, 5)
        assertArrayEquals(expected, arr.runningSumNaive())
    }
}

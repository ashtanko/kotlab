package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SmallerNumbersThanCurrentTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(8, 1, 2, 2, 3)
        val expected = intArrayOf(4, 0, 1, 1, 3)
        assertArrayEquals(expected, arr.smallerNumbersThanCurrent())
    }

    @Test
    fun `simple test 1`() {
        val arr = intArrayOf(6, 5, 4, 8)
        val expected = intArrayOf(2, 1, 0, 3)
        assertArrayEquals(expected, arr.smallerNumbersThanCurrent())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(7, 7, 7, 7)
        val expected = intArrayOf(0, 0, 0, 0)
        assertArrayEquals(expected, arr.smallerNumbersThanCurrent())
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(8, 1, 2, 2, 3)
        val expected = intArrayOf(4, 0, 1, 1, 3)
        assertArrayEquals(expected, arr.smallerNumbersThanCurrentNaive())
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(6, 5, 4, 8)
        val expected = intArrayOf(2, 1, 0, 3)
        assertArrayEquals(expected, arr.smallerNumbersThanCurrentNaive())
    }

    @Test
    fun `simple test 5`() {
        val arr = intArrayOf(7, 7, 7, 7)
        val expected = intArrayOf(0, 0, 0, 0)
        assertArrayEquals(expected, arr.smallerNumbersThanCurrentNaive())
    }
}

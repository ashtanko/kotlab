package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SortedSquaresTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(-4, -1, 0, 3, 10)
        val expected = intArrayOf(0, 1, 9, 16, 100)
        val actual = arr.sortedSquares()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(-7, -3, 2, 3, 11)
        val expected = intArrayOf(4, 9, 9, 49, 121)
        val actual = arr.sortedSquares()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(-4, -1, 0, 3, 10)
        val expected = intArrayOf(0, 1, 9, 16, 100)
        val actual = arr.sortedSquares2()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(-7, -3, 2, 3, 11)
        val expected = intArrayOf(4, 9, 9, 49, 121)
        val actual = arr.sortedSquares2()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 5`() {
        val arr = intArrayOf(-4, -1, 0, 3, 10)
        val expected = intArrayOf(0, 1, 9, 16, 100)
        val actual = arr.sortedSquares3()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 6`() {
        val arr = intArrayOf(-7, -3, 2, 3, 11)
        val expected = intArrayOf(4, 9, 9, 49, 121)
        val actual = arr.sortedSquares3()
        assertArrayEquals(expected, actual)
    }
}

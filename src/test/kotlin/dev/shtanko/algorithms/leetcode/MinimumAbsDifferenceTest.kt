package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAbsDifferenceTest {

    // TODO
    @Test
    fun `simple test`() {
        val arr = intArrayOf(4, 2, 1, 3)
        val expected = listOf(
            listOf(1, 2),
            listOf(2, 3),
            listOf(3, 4)
        )
        val actual = arr.minimumAbsDifference()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 3, 6, 10, 15)
        val expected = listOf(
            listOf(1, 3)
        )
        val actual = arr.minimumAbsDifference()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(3, 8, -10, 23, 19, -4, -14, 27)
        val expected = listOf(
            listOf(-14, -10),
            listOf(19, 23),
            listOf(23, 27)
        )
        val actual = arr.minimumAbsDifference()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(4, 2, 1, 3)
        val expected = listOf(
            listOf(1, 2),
            listOf(2, 3),
            listOf(3, 4)
        )
        val actual = arr.minimumAbsDifference2()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 5`() {
        val arr = intArrayOf(1, 3, 6, 10, 15)
        val expected = listOf(
            listOf(1, 3)
        )
        val actual = arr.minimumAbsDifference2()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 6`() {
        val arr = intArrayOf(3, 8, -10, 23, 19, -4, -14, 27)
        val expected = listOf(
            listOf(-14, -10),
            listOf(19, 23),
            listOf(23, 27)
        )
        val actual = arr.minimumAbsDifference2()
        assertEquals(expected, actual)
    }
}

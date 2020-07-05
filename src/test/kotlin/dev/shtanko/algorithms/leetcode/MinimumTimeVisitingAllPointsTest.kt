package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeVisitingAllPointsTest {

    @Test
    fun `simple test`() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(3, 4),
            intArrayOf(-1, 0)
        )

        val actual = points.minTimeToVisitAllPoints()
        val expected = 7

        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val points = arrayOf(
            intArrayOf(3, 2),
            intArrayOf(-2, 2)
        )

        val actual = points.minTimeToVisitAllPoints()
        val expected = 5

        assertEquals(expected, actual)
    }
}

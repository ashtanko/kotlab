package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxPointsTest {

    @Test
    fun `simple test`() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3)
        )

        assertEquals(3, points.maxPoints())
    }

    @Test
    fun `simple test 2`() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(3, 2),
            intArrayOf(5, 3),
            intArrayOf(4, 1),
            intArrayOf(2, 3),
            intArrayOf(1, 4)
        )
        assertEquals(4, points.maxPoints())
    }
}

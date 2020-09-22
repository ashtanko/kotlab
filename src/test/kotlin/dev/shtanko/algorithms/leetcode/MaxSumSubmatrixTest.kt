package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxSumSubmatrixTest {

    @Test
    fun `simple test`() {
        val matrix = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, -2, 3)
        )
        val k = 2
        val actual = maxSumSubmatrix(matrix, k)
        val expected = 2
        assertEquals(expected, actual)
    }
}

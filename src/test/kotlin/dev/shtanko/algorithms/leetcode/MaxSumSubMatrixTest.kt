package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxSumSubMatrixTest {

    @Test
    fun `simple test`() {
        val matrix = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, -2, 3)
        )
        val k = 2
        val actual = maxSumSubMatrix(matrix, k)
        val expected = 2
        assertEquals(expected, actual)
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubArrayTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        val actual = arr.maxSubArray()
        assertEquals(6, actual)
    }
}

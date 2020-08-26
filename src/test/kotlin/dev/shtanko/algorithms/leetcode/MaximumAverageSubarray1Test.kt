package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAverageSubarray1Test {

    @Test
    fun `simple test`() {
        val nums = intArrayOf(1, 12, -5, -6, 50, 3)
        val k = 4
        val actual = findMaxAverage(nums, k)
        assertEquals(12.75, actual)
    }

    @Test
    fun `simple test 2`() {
        val nums = intArrayOf(1, 12, -5, -6, 50, 3)
        val k = 4
        val actual = findMaxAverage2(nums, k)
        assertEquals(12.75, actual)
    }
}

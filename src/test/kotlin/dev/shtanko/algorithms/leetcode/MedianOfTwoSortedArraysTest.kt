package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MedianOfTwoSortedArraysTest {

    @Test
    fun `simple test`() {
        val pair = intArrayOf(1, 3) to intArrayOf(2)
        val median = pair.findMedianSortedArrays()
        assertEquals(2.0, median)
    }

    @Test
    fun `simple test 2`() {
        val pair = intArrayOf(1, 2) to intArrayOf(3, 4)
        val median = pair.findMedianSortedArrays()
        assertEquals(2.5, median)
    }
}

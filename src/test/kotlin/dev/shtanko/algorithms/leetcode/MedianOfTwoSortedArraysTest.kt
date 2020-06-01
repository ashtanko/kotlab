package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Test

class MedianOfTwoSortedArraysTest {

    @Test
    fun `simple test`() {
        val pair = intArrayOf(1, 3) to intArrayOf(2)
        val median = pair.findMedianSortedArrays()
        println(median)
    }
}
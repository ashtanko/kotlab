package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SummaryRangesTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(0, 1, 2, 4, 5, 7)
        val summaryRanges = arr.summaryRanges()
        assertEquals(listOf("0->2", "4->5", "7"), summaryRanges)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(0, 2, 3, 4, 6, 8, 9)
        val summaryRanges = arr.summaryRanges()
        assertEquals(listOf("0", "2->4", "6", "8->9"), summaryRanges)
    }
}

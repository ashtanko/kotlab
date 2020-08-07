package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestRangeITest {

    @Test
    fun `simple test`() {
        assertEquals(0, (intArrayOf(1) to 0).smallestRangeI())
    }

    @Test
    fun `simple test 2`() {
        assertEquals(6, (intArrayOf(0, 10) to 2).smallestRangeI())
    }

    @Test
    fun `simple test 3`() {
        assertEquals(0, (intArrayOf(1, 3, 6) to 3).smallestRangeI())
    }
}

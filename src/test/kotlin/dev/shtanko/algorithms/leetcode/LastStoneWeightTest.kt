package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LastStoneWeightTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(2, 7, 4, 1, 8, 1)
        assertEquals(1, arr.lastStoneWeight())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(2, 7, 4, 1, 8, 1)
        assertEquals(1, arr.lastStoneWeightQueue())
    }
}

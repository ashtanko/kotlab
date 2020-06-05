package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrappingRainWaterTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
        val actual = arr.trapRainWater()
        assertEquals(6, actual)
    }

}
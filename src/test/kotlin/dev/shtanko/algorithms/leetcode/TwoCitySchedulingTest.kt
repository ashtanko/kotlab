package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TwoCitySchedulingTest {

    @Test
    fun `simple test`() {
        val costs = arrayOf(
            intArrayOf(10, 20),
            intArrayOf(30, 200),
            intArrayOf(400, 50),
            intArrayOf(30, 20)
        )
        assertEquals(110, costs.twoCitySchedCost())
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestSightseeingPairTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(8, 1, 5, 2, 6)
        assertEquals(11, maxScoreSightseeingPair(arr))
    }
}

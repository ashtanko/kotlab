package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStock2Test {

    @Test
    fun `simple test`() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        val maxProfit = prices.maxProfit()
        assertEquals(7, maxProfit)
    }

    @Test
    fun `simple test 2`() {
        val prices = intArrayOf(1, 2, 3, 4, 5)
        val maxProfit = prices.maxProfit()
        assertEquals(4, maxProfit)
    }

    @Test
    fun `simple test 3`() {
        val prices = intArrayOf(7, 6, 4, 3, 1)
        val maxProfit = prices.maxProfit()
        assertEquals(0, maxProfit)
    }
}

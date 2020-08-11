package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockTest {

    @Test
    fun `simple test`() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        val maxProfit = prices.maxProfitSimple()
        assertEquals(5, maxProfit)
    }

    @Test
    fun `simple test 2`() {
        val prices = intArrayOf(7, 6, 4, 3, 1)
        val maxProfit = prices.maxProfitSimple()
        assertEquals(0, maxProfit)
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class BestTimeToBuyAndSellStockTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                5 to listOf(7, 1, 5, 3, 6, 4),
                0 to listOf(7, 6, 4, 3, 1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple max profit test`(param: Pair<Int, List<Int>>) {
        val maxProfit = param.second.toIntArray().maxProfitSimple()
        assertEquals(param.first, maxProfit)
    }
}

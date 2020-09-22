package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class BestTimeToBuyAndSellStock2Test {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                7 to listOf(7, 1, 5, 3, 6, 4),
                4 to listOf(1, 2, 3, 4, 5),
                0 to listOf(7, 6, 4, 3, 1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `max profit test`(param: Pair<Int, List<Int>>) {
        val maxProfit = param.second.toIntArray().maxProfit()
        assertEquals(param.first, maxProfit)
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class BestTimeToBuyAndSellStockTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                5 to intArrayOf(7, 1, 5, 3, 6, 4),
                0 to intArrayOf(7, 6, 4, 3, 1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple max profit test`(param: Pair<Int, IntArray>) {
        val (expected, arr) = param
        val actual = arr.maxProfitSimple()
        assertEquals(expected, actual)
    }
}

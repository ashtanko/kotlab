package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class AbstractSortByParityStrategyTest<out T : AbstractSortByParityStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(4, 2, 5, 7) to intArrayOf(4, 5, 2, 7),
                intArrayOf(1, 2, 3, 4) to intArrayOf(2, 1, 4, 3),
                intArrayOf(4, 8, 15, 16, 23, 41) to intArrayOf(4, 15, 8, 23, 16, 41)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `sort by parity test`(testCase: Pair<IntArray, IntArray>) {
        val arr = testCase.first
        val expected = testCase.second
        val actual = strategy.perform(arr)
        assertArrayEquals(expected, actual)
    }
}

class SortByParityTwoPassTest : AbstractSortByParityStrategyTest<SortByParityTwoPass>(SortByParityTwoPass())

class SortByParityHeadsTest : AbstractSortByParityStrategyTest<SortByParityHeads>(SortByParityHeads())

class SortByParityStraightForwardTest :
    AbstractSortByParityStrategyTest<SortByParityStraightForward>(SortByParityStraightForward())

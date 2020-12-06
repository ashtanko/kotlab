package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class NumOfSubArraysTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                4 to intArrayOf(1, 3, 5),
                0 to intArrayOf(2, 4, 6)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `num of sub arrays test`(data: Pair<Int, IntArray>) {
        val (expected, arr) = data
        val actual = numOfSubArrays(arr)
        assertEquals(expected, actual)
    }
}

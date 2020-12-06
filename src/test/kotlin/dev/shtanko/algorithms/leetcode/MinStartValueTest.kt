package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class MinStartValueTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, IntArray>> {
            return listOf(
                5 to intArrayOf(-3, 2, -3, 4, 2),
                1 to intArrayOf(1, 2),
                5 to intArrayOf(1, -2, -3)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `find min start value test`(testCase: Pair<Int, IntArray>) {
        val (expected, arr) = testCase
        val actual = arr.findMinStartValue()
        assertEquals(expected, actual)
    }
}

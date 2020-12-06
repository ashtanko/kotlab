package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class MedianOfTwoSortedArraysTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Double, Pair<IntArray, IntArray>>> {
            return listOf(
                2.0 to (intArrayOf(1, 3) to intArrayOf(2)),
                2.5 to (intArrayOf(1, 2) to intArrayOf(3, 4))
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `median of two sorted arrays test`(testCase: Pair<Double, Pair<IntArray, IntArray>>) {
        val (expected, pair) = testCase
        val median = pair.findMedianSortedArrays()
        assertEquals(expected, median)
    }
}

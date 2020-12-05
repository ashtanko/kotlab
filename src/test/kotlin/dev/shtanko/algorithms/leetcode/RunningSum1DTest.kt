package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class RunningSum1DTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf() to intArrayOf(),
                intArrayOf(1, 2, 3, 4) to intArrayOf(1, 3, 6, 10),
                intArrayOf(1, 1, 1, 1, 1) to intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(3, 1, 2, 10, 1) to intArrayOf(3, 4, 6, 16, 17),
                intArrayOf(-3, 1, -2, 10, -1) to intArrayOf(-3, -2, -4, 6, 5)
            )
        }
    }

    @Test
    internal fun `is empty test`() {
        val arr = intArrayOf()
        assertTrue(arr.runningSumNaive().isEmpty())
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `running sum naive test`(testCase: Pair<IntArray, IntArray>) {
        val (arr, expected) = testCase
        val actual = arr.runningSumNaive()
        assertArrayEquals(expected, actual)
    }
}

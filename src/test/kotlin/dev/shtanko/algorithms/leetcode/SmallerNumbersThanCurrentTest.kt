package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SmallerNumbersThanCurrentTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(8, 1, 2, 2, 3) to intArrayOf(4, 0, 1, 1, 3),
                intArrayOf(6, 5, 4, 8) to intArrayOf(2, 1, 0, 3),
                intArrayOf(7, 7, 7, 7) to intArrayOf(0, 0, 0, 0)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `smaller numbers than current test`(testCase: Pair<IntArray, IntArray>) {
        val arr = testCase.first
        val expected = testCase.second
        val actual = arr.smallerNumbersThanCurrent()
        assertArrayEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `smaller numbers than current naive test`(testCase: Pair<IntArray, IntArray>) {
        val arr = testCase.first
        val expected = testCase.second
        val actual = arr.smallerNumbersThanCurrentNaive()
        assertArrayEquals(expected, actual)
    }
}

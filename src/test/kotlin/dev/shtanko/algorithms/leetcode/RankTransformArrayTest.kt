package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class RankTransformArrayTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(40, 10, 20, 30) to intArrayOf(4, 1, 2, 3),
                intArrayOf(100, 100, 100) to intArrayOf(1, 1, 1),
                intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12) to intArrayOf(5, 3, 4, 2, 8, 6, 7, 1, 3)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `array rank transform test`(testCase: Pair<IntArray, IntArray>) {
        val arr = testCase.first
        val expected = testCase.second
        val actual = arr.arrayRankTransform()
        assertArrayEquals(expected, actual)
    }
}

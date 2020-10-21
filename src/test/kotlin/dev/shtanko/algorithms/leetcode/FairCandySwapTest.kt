package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class FairCandySwapTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, IntArray>, IntArray>> {
            return listOf(
                intArrayOf(1, 1) to intArrayOf(2, 2) to intArrayOf(1, 2),
                intArrayOf(1, 2) to intArrayOf(2, 3) to intArrayOf(1, 2),
                intArrayOf(2) to intArrayOf(1, 3) to intArrayOf(2, 3),
                intArrayOf(1, 2, 5) to intArrayOf(2, 4) to intArrayOf(5, 4)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `fair candy swap test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val actual = testCase.first.fairCandySwap()
        val expected = testCase.second
        assertArrayEquals(expected, actual)
    }
}

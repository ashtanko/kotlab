package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ShuffleArrayTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, IntArray>> {
            return listOf(
                (intArrayOf(2, 5, 1, 3, 4, 7) to 3) to intArrayOf(2, 3, 5, 4, 1, 7),
                (intArrayOf(1, 2, 3, 4, 4, 3, 2, 1) to 4) to intArrayOf(1, 4, 2, 3, 3, 2, 4, 1),
                (intArrayOf(1, 1, 2, 2) to 2) to intArrayOf(1, 2, 1, 2),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `shuffle test`(testCase: Pair<Pair<IntArray, Int>, IntArray>) {
        val arr = testCase.first.first
        val n = testCase.first.second
        val expected = testCase.second
        val actual = arr.shuffle(n)
        assertArrayEquals(expected, actual)
    }
}

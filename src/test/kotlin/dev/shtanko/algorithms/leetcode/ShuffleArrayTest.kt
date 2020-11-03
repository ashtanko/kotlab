package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ShuffleArrayTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, IntArray>> {
            return listOf(
                Pair(Pair(intArrayOf(2, 5, 1, 3, 4, 7), 3), intArrayOf(2, 3, 5, 4, 1, 7)),
                Pair(Pair(intArrayOf(1, 2, 3, 4, 4, 3, 2, 1), 4), intArrayOf(1, 4, 2, 3, 3, 2, 4, 1)),
                Pair(Pair(intArrayOf(1, 1, 2, 2), 2), intArrayOf(1, 2, 1, 2))
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

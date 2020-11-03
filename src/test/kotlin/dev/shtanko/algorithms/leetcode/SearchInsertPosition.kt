package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SearchInsertPosition {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Int>> {
            return listOf(
                Pair(Pair(intArrayOf(), 1), 0),
                Pair(Pair(intArrayOf(1, 3, 5, 6), 5), 2),
                Pair(Pair(intArrayOf(1, 3, 5, 6), 2), 1),
                Pair(Pair(intArrayOf(1, 3, 5, 6), 7), 4),
                Pair(Pair(intArrayOf(1, 3, 5, 6), 0), 0)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `search insert position test`(testCase: Pair<Pair<IntArray, Int>, Int>) {
        val arr = testCase.first.first
        val target = testCase.first.second
        val expected = testCase.second
        val actual = arr.searchInsertPosition(target)
        assertEquals(expected, actual)
    }
}

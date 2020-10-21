package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ElementPositionTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Int, IntArray>, IntArray>> {
            return listOf(
                4 to intArrayOf() to intArrayOf(-1, -1),
                8 to intArrayOf(5, 7, 7, 8, 8, 10) to intArrayOf(3, 4),
                6 to intArrayOf(5, 7, 7, 8, 8, 10) to intArrayOf(-1, -1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `search range test`(testCase: Pair<Pair<Int, IntArray>, IntArray>) {
        val arr = testCase.first.second
        val target = testCase.first.first
        val actual = arr.searchRange(target)
        val expected = testCase.second
        assertArrayEquals(expected, actual)
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MoveZeroesTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(0, 1, 0, 3, 12) to intArrayOf(1, 3, 12, 0, 0),
                intArrayOf(0, 0, 1, 3, 0) to intArrayOf(1, 3, 0, 0, 0)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    fun `simple test`(testCase: Pair<IntArray, IntArray>) {
        val arr = testCase.first
        val expected = testCase.second
        arr.moveZeroes()
        assertArrayEquals(expected, arr)
    }
}

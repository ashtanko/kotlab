package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumTeamsTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, IntArray>> {
            return listOf(
                3 to intArrayOf(2, 5, 3, 4, 1),
                0 to intArrayOf(2, 1, 3),
                4 to intArrayOf(1, 2, 3, 4)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    fun `simple test`(testCase: Pair<Int, IntArray>) {
        val arr = testCase.second
        val expected = testCase.first
        assertEquals(expected, arr.numTeams())
    }
}

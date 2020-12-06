package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class NumTeamsTest {

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
    internal fun `num teams test`(testCase: Pair<Int, IntArray>) {
        val (expected, arr) = testCase
        val actual = arr.numTeams()
        assertEquals(expected, actual)
    }
}

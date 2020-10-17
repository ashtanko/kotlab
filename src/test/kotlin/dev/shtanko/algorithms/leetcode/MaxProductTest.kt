package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MaxProductTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, IntArray>> {
            return listOf(
                1 to intArrayOf(),
                0 to intArrayOf(1),
                0 to intArrayOf(1, 2),
                2 to intArrayOf(1, 2, 3),
                12 to intArrayOf(3, 4, 5, 2),
                16 to intArrayOf(1, 5, 4, 5),
                12 to intArrayOf(3, 7)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    fun `max product test`(testCase: Pair<Int, IntArray>) {
        val arr = testCase.second
        val expected = testCase.first
        assertEquals(expected, arr.maxProduct())
    }
}

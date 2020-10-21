package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SmallestRangeITest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Int>> {
            return listOf(
                (intArrayOf(1) to 0) to 0,
                (intArrayOf(0, 10) to 2) to 6,
                (intArrayOf(1, 3, 6) to 3) to 0
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Pair<IntArray, Int>, Int>) {
        val expected = testCase.second
        val actual = testCase.first.smallestRangeI()
        assertEquals(expected, actual)
    }
}

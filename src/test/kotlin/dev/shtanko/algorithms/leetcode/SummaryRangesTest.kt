package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SummaryRangesTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, List<String>>> {
            return listOf(
                intArrayOf(0, 1, 2, 4, 5, 7) to listOf("0->2", "4->5", "7"),
                intArrayOf(0, 2, 3, 4, 6, 8, 9) to listOf("0", "2->4", "6", "8->9")
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `summary ranges test`(testCase: Pair<IntArray, List<String>>) {
        val arr = testCase.first
        val expected = testCase.second
        val summaryRanges = arr.summaryRanges()
        assertEquals(expected, summaryRanges)
    }
}

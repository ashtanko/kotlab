package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class HandOfStraightsTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Boolean>> {
            return listOf(
                intArrayOf(1, 2, 3, 6, 2, 3, 4, 7, 8) to 3 to true,
                intArrayOf(1, 2, 3, 4, 5) to 4 to false
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Pair<IntArray, Int>, Boolean>) {
        val actual = isNStraightHand(testCase.first.first, testCase.first.second)
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}

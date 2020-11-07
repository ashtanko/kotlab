package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MajorityElementTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(3, 2, 3) to 3,
                intArrayOf(2, 2, 1, 1, 1, 2, 2) to 2
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<IntArray, Int>) {
        val arr = testCase.first
        val actual = arr.majorityElement()
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class RemoveElementTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Int>> {
            return listOf(
                intArrayOf(2, 3, 3, 2) to 4 to 4,
                intArrayOf(2, 3, 3, 2) to 2 to 2,
                intArrayOf(0, 1, 2, 2, 3, 0, 4, 2) to 2 to 5
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `remove element test`(testCase: Pair<Pair<IntArray, Int>, Int>) {
        val arr = testCase.first.first
        val size = arr.removeElement(testCase.first.second)
        val expected = testCase.second
        assertEquals(expected, size)
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ThreeSumTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, List<List<Int>>>> {
            return listOf(
                intArrayOf(0, 0, 1) to listOf(),
                intArrayOf(-1, 0, 1, 2, -1, -4) to listOf(
                    listOf(-1, -1, 2),
                    listOf(-1, 0, 1)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `three sum test`(testCase: Pair<IntArray, List<List<Int>>>) {
        val (array, expected) = testCase
        val actual = array.threeSum()
        assertEquals(expected, actual)
    }
}

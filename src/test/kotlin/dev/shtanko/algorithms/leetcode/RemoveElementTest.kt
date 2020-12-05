package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveElementTest {

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
    internal fun `remove element test`(testCase: Pair<Pair<IntArray, Int>, Int>) {
        val (data, expected) = testCase
        val (arr, elem) = data
        val size = arr.removeElement(elem)
        assertEquals(expected, size)
    }
}

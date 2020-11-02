package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.PancakeSortLeetcode.pancakeSort
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PancakeSortingTest {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, List<Int>>> =
            listOf(
                intArrayOf(3, 2, 4, 1) to listOf(3, 4, 2, 3, 2),
                intArrayOf(1, 2, 3) to emptyList()
            )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `pancake sort test`(testCase: Pair<IntArray, List<Int>>) {
        val expected = testCase.second
        val actual = pancakeSort(testCase.first)
        assertEquals(expected, actual)
    }
}

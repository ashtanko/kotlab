package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class DuplicateZerosTest {
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(1, 0, 2, 3, 0, 4, 5, 0) to intArrayOf(1, 0, 0, 2, 3, 0, 0, 4),
                intArrayOf(1, 2, 3) to intArrayOf(1, 2, 3)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `duplicate zeros test`(testCase: Pair<IntArray, IntArray>) {
        val expected = testCase.second
        val arr = testCase.first
        duplicateZeros(arr)
        println(arr.toList())
        assertArrayEquals(expected, arr)
    }
}

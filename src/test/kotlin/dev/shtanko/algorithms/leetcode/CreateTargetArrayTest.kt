package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CreateTargetArrayTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, IntArray>, IntArray>> {
            return listOf(
                intArrayOf(0, 1, 2, 3, 4) to intArrayOf(0, 1, 2, 2, 1) to intArrayOf(0, 4, 1, 3, 2),
                intArrayOf(1, 2, 3, 4, 0) to intArrayOf(0, 1, 2, 3, 0) to intArrayOf(0, 1, 2, 3, 4),
                intArrayOf(1) to intArrayOf(0) to intArrayOf(1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `create target array solution test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val pair = testCase.first
        val expected = testCase.second
        val actual = pair.createTargetArray()
        assertArrayEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `create target array solution 2 test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val pair = testCase.first
        val expected = testCase.second
        val actual = pair.createTargetArray2()
        assertArrayEquals(expected, actual)
    }
}

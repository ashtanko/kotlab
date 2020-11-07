package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class TheKWeakestRowsInMatrixTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Array<IntArray>, Int>, IntArray>> {
            return listOf(
                arrayOf(
                    intArrayOf(1, 1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 0),
                    intArrayOf(1, 0, 0, 0, 0),
                    intArrayOf(1, 1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1)
                ) to 3 to intArrayOf(2, 0, 3),
                arrayOf(
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(1, 0, 0, 0)
                ) to 2 to intArrayOf(0, 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `kWeakest rows test`(testCase: Pair<Pair<Array<IntArray>, Int>, IntArray>) {
        val matrix = testCase.first.first
        val k = testCase.first.second
        val data = matrix to k
        val expected = testCase.second
        val actual = data.kWeakestRows()
        assertArrayEquals(expected, actual)
    }
}

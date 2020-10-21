package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SpiralMatrixTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Array<IntArray>, List<Int>>> {
            return listOf(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ) to listOf(1, 2, 3, 6, 9, 8, 7, 4, 5),
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12)
                ) to listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12),
                    intArrayOf(13, 14, 15, 16)
                ) to listOf(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10)
            )
        }

        @JvmStatic
        fun dataProvider2(): List<Pair<Int, Array<IntArray>>> {
            return listOf(
                3 to arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(8, 9, 4),
                    intArrayOf(7, 6, 5)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `spiral order test`(testCase: Pair<Array<IntArray>, List<Int>>) {
        val matrix = testCase.first
        val actual = matrix.spiralOrder()
        val expected = testCase.second

        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider2")
    fun `generate spiral matrix test`(testCase: Pair<Int, Array<IntArray>>) {
        val matrix = testCase.second
        val num = testCase.first
        val actual = num.generateSpiralMatrix()
        assertArrayEquals(matrix, actual)
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class FlipAndInvertImageTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Array<IntArray>, Array<IntArray>>> {
            return listOf(
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, 0, 0)
                ) to arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 1, 1)
                ),
                arrayOf(
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(1, 0, 0, 1),
                    intArrayOf(0, 1, 1, 1),
                    intArrayOf(1, 0, 1, 0)
                ) to arrayOf(
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(1, 0, 1, 0)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `flip and invert image test`(testCase: Pair<Array<IntArray>, Array<IntArray>>) {
        val arr = testCase.first
        val expected = testCase.second
        val actual = flipAndInvertImage(arr)
        assertArrayEquals(expected, actual)
    }
}

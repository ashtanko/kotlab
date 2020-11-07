package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class RotateImageTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Array<IntArray>, Array<IntArray>>> {
            return listOf(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ) to arrayOf(
                    intArrayOf(7, 4, 1),
                    intArrayOf(8, 5, 2),
                    intArrayOf(9, 6, 3)
                ),
                arrayOf(
                    intArrayOf(5, 1, 9, 11),
                    intArrayOf(2, 4, 8, 10),
                    intArrayOf(13, 3, 6, 7),
                    intArrayOf(15, 14, 12, 16)
                ) to arrayOf(
                    intArrayOf(15, 13, 2, 5),
                    intArrayOf(14, 3, 4, 1),
                    intArrayOf(12, 6, 8, 9),
                    intArrayOf(16, 7, 10, 11)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `rotate image test`(testCase: Pair<Array<IntArray>, Array<IntArray>>) {
        val arr = testCase.first
        arr.rotateImage()
        val expected = testCase.second
        assertArrayEquals(expected, arr)
    }
}

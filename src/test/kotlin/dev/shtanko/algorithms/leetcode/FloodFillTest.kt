package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

data class FloodFillTestCase(
    val image: List<IntArray>,
    val sr: Int,
    val sc: Int,
    val newColor: Int,
    val output: List<IntArray>
)

class FloodFillTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<FloodFillTestCase> {
            return listOf(
                FloodFillTestCase(
                    listOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1)),
                    1,
                    1,
                    2,
                    listOf(intArrayOf(2, 2, 2), intArrayOf(2, 2, 0), intArrayOf(2, 0, 1))
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `flood fill test`(testCase: FloodFillTestCase) {
        val actual = FloodFill.perform(testCase.image.toTypedArray(), testCase.sr, testCase.sc, testCase.newColor)
        val expected = testCase.output.toTypedArray()
        assertArrayEquals(expected, actual)
    }
}

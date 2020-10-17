package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MaxPointsTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, Array<IntArray>>> {
            return listOf(
                0 to arrayOf(),
                1 to arrayOf(intArrayOf(1)),
                3 to arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3)
                ),
                4 to arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(3, 2),
                    intArrayOf(5, 3),
                    intArrayOf(4, 1),
                    intArrayOf(2, 3),
                    intArrayOf(1, 4)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    fun `max points test`(testCase: Pair<Int, Array<IntArray>>) {
        val points = testCase.second
        val expected = testCase.first
        assertEquals(expected, points.maxPoints())
    }
}

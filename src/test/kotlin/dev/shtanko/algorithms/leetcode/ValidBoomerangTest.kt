package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ValidBoomerangTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, Array<IntArray>>> {
            return listOf(
                true to arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 3),
                    intArrayOf(3, 2)
                ),
                false to arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is boomerang test`(testCase: Pair<Boolean, Array<IntArray>>) {
        val (expected, points) = testCase
        val actual = isBoomerang(points)
        assertEquals(expected, actual)
    }
}

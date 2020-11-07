package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ValidBoomerangTest {

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
    fun `is boomerang test`(testCase: Pair<Boolean, Array<IntArray>>) {
        val points = testCase.second
        val actual = isBoomerang(points)
        if (testCase.first) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}

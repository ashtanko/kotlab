package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class MajorityCheckerTest {

    private val array = intArrayOf(1, 1, 2, 2, 1, 1)

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Triple<Int, Int, Int>>> {
            return listOf(
                1 to Triple(0, 5, 4),
                -1 to Triple(0, 3, 3),
                2 to Triple(2, 3, 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `majority checker test`(testCase: Pair<Int, Triple<Int, Int, Int>>) {
        val (expected, data) = testCase
        val (left, right, threshold) = data
        val actual = MajorityChecker(array).query(left, right, threshold)
        assertEquals(expected, actual)
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class AverageSalaryTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                intArrayOf(4000, 3000, 1000, 2000) to 2500.00000,
                intArrayOf(1000, 2000, 3000) to 2000.00000,
                intArrayOf(6000, 5000, 4000, 3000, 2000, 1000) to 3500.00000,
                intArrayOf(8000, 9000, 2000, 3000, 6000, 1000) to 4750.00000
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `average salary test`(param: Pair<IntArray, Double>) {
        val (arr, expected) = param
        val actual = arr.averageSalary()
        assertEquals(expected, actual)
    }
}

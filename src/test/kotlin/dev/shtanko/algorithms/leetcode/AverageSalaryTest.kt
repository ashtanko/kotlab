package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class AverageSalaryTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                2500.00000 to listOf(4000, 3000, 1000, 2000),
                2000.00000 to listOf(1000, 2000, 3000),
                3500.00000 to listOf(6000, 5000, 4000, 3000, 2000, 1000),
                4750.00000 to listOf(8000, 9000, 2000, 3000, 6000, 1000)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `average salary test`(param: Pair<Double, List<Int>>) {
        val arr = param.second
        val expected = param.first
        val actual = arr.toIntArray().averageSalary()
        assertEquals(expected, actual)
    }
}

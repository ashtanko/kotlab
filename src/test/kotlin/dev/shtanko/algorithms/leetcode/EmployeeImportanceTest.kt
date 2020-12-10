package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class EmployeeImportanceTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Int, List<EmployeeImportance.Employee>>, Int>> {
            return listOf(
                1 to listOf(
                    EmployeeImportance.Employee(1, 5, listOf(2, 3)),
                    EmployeeImportance.Employee(2, 3, listOf()),
                    EmployeeImportance.Employee(3, 3, listOf()),
                ) to 11,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `employee importance test`(testCase: Pair<Pair<Int, List<EmployeeImportance.Employee>>, Int>) {
        val (data, expected) = testCase
        val (id, employees) = data
        val actual = EmployeeImportance.getImportance(employees, id)
        assertEquals(expected, actual)
    }
}

/*
 * Copyright 2020 Alexey Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

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

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
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
                intArrayOf(8000, 9000, 2000, 3000, 6000, 1000) to 4750.00000,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `average salary test`(param: Pair<IntArray, Double>) {
        val (arr, expected) = param
        val actual = arr.averageSalary()
        assertThat(actual, equalTo(expected))
    }
}

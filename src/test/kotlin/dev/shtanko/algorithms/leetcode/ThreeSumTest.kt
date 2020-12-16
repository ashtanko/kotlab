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

internal class ThreeSumTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, List<List<Int>>>> {
            return listOf(
                intArrayOf(0, 0, 1) to listOf(),
                intArrayOf(-1, 0, 1, 2, -1, -4) to listOf(
                    listOf(-1, -1, 2),
                    listOf(-1, 0, 1)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `three sum test`(testCase: Pair<IntArray, List<List<Int>>>) {
        val (array, expected) = testCase
        val actual = array.threeSum()
        assertEquals(expected, actual)
    }
}

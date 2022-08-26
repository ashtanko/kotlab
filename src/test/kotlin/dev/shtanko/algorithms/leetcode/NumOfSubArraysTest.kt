/*
 * Copyright 2020 Oleksii Shtanko
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

internal class NumOfSubArraysTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                4 to intArrayOf(1, 3, 5),
                0 to intArrayOf(2, 4, 6),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `num of sub arrays test`(data: Pair<Int, IntArray>) {
        val (expected, arr) = data
        val actual = numOfSubArrays(arr)
        assertEquals(expected, actual)
    }
}

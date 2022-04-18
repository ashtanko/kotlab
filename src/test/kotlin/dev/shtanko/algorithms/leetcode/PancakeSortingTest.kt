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

import dev.shtanko.algorithms.leetcode.PancakeSortLeetcode.pancakeSort
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class PancakeSortingTest {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, List<Int>>> =
            listOf(
                intArrayOf(3, 2, 4, 1) to listOf(3, 4, 2, 3, 2),
                intArrayOf(1, 2, 3) to emptyList()
            )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `pancake sort test`(testCase: Pair<IntArray, List<Int>>) {
        val (arr, expected) = testCase
        val actual = pancakeSort(arr)
        assertEquals(expected, actual)
    }
}

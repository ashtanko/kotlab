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

internal class RemoveElementTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Int>> {
            return listOf(
                intArrayOf(2, 3, 3, 2) to 4 to 4,
                intArrayOf(2, 3, 3, 2) to 2 to 2,
                intArrayOf(0, 1, 2, 2, 3, 0, 4, 2) to 2 to 5
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `remove element test`(testCase: Pair<Pair<IntArray, Int>, Int>) {
        val (data, expected) = testCase
        val (arr, elem) = data
        val size = arr.removeElement(elem)
        assertEquals(expected, size)
    }
}

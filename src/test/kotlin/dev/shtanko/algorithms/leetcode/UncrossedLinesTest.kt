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

internal class UncrossedLinesTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, IntArray>, Int>> {
            return listOf(
                intArrayOf(1, 4, 2) to intArrayOf(1, 2, 4) to 2,
                intArrayOf(2, 5, 1, 2, 5) to intArrayOf(10, 5, 2, 1, 5, 2) to 3,
                intArrayOf(1, 3, 7, 1, 7, 5) to intArrayOf(1, 9, 2, 5, 1) to 2
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `max uncrossed lines test`(testCase: Pair<Pair<IntArray, IntArray>, Int>) {
        val (numbers, expected) = testCase
        val actual = numbers.maxUncrossedLines()
        assertEquals(expected, actual)
    }
}

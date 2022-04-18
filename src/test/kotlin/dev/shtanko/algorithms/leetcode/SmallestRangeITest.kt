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

internal class SmallestRangeITest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Int>> {
            return listOf(
                Pair(Pair(intArrayOf(1), 0), 0),
                Pair(Pair(intArrayOf(0, 10), 2), 6),
                Pair(Pair(intArrayOf(1, 3, 6), 3), 0)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `smallest range I test`(testCase: Pair<Pair<IntArray, Int>, Int>) {
        val (data, expected) = testCase
        val actual = data.smallestRangeI()
        assertEquals(expected, actual)
    }
}

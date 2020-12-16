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

internal class SummaryRangesTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, List<String>>> {
            return listOf(
                intArrayOf(0, 1, 2, 4, 5, 7) to listOf("0->2", "4->5", "7"),
                intArrayOf(0, 2, 3, 4, 6, 8, 9) to listOf("0", "2->4", "6", "8->9")
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `summary ranges test`(testCase: Pair<IntArray, List<String>>) {
        val (arr, expected) = testCase
        val summaryRanges = arr.summaryRanges()
        assertEquals(expected, summaryRanges)
    }
}

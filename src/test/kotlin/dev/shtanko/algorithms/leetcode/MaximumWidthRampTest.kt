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

internal abstract class MaximumWidthRampTest<out T : MaximumWidthRampStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(6, 0, 8, 2, 1, 5) to 4,
                intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1) to 7,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `maximum width ramp test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = strategy.maxWidthRamp(arr)
        assertEquals(expected, actual)
    }
}

internal class MaximumWidthRampSortTest : MaximumWidthRampTest<MaximumWidthRampSort>(MaximumWidthRampSort())

internal class MaximumWidthRampBinarySearchTest :
    MaximumWidthRampTest<MaximumWidthRampBinarySearch>(MaximumWidthRampBinarySearch())

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

internal abstract class FindPeakElementTest<out T : FindPeakElementStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider() = listOf(
            intArrayOf() to 0,
            intArrayOf(1, 2, 3, 1) to 2,
            intArrayOf(1, 2, 1, 3, 5, 6, 4) to 5,
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `find peek element`(testCase: Pair<IntArray, Int>) {
        val (nums, expected) = testCase
        val actual = strategy.perform(nums)
        assertEquals(expected, actual)
    }
}

internal class FindPeakElementLinearTest : FindPeakElementTest<FindPeakElementLinear>(FindPeakElementLinear())

internal class FindPeakElementRecursiveBinarySearchTest :
    FindPeakElementTest<FindPeakElementRecursiveBinarySearch>(FindPeakElementRecursiveBinarySearch())

internal class FindPeakElementIterativeBinarySearchTest :
    FindPeakElementTest<FindPeakElementIterativeBinarySearch>(FindPeakElementIterativeBinarySearch())

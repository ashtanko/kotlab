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

internal class HeightCheckerTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(1, 1, 4, 2, 1, 3) to 3,
                intArrayOf(5, 1, 2, 3, 4) to 5,
                intArrayOf(1, 2, 3, 4, 5) to 0,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `height checker sort test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.heightCheckerSort()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `height checker test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.heightChecker()
        assertEquals(expected, actual)
    }
}

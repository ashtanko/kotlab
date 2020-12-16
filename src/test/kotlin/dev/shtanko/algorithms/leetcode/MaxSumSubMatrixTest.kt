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

internal class MaxSumSubMatrixTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Pair<Int, Array<IntArray>>, Int>> {
            return listOf(
                2 to arrayOf(
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, -2, 3)
                ) to 2
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `max sum sub matrix test`(testCase: Pair<Pair<Int, Array<IntArray>>, Int>) {
        val (data, expected) = testCase
        val (k, matrix) = data
        val actual = maxSumSubMatrix(matrix, k)
        assertEquals(expected, actual)
    }
}

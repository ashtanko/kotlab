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

internal class MaxPointsTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, Array<IntArray>>> {
            return listOf(
                0 to arrayOf(),
                1 to arrayOf(intArrayOf(1)),
                3 to arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3),
                ),
                4 to arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(3, 2),
                    intArrayOf(5, 3),
                    intArrayOf(4, 1),
                    intArrayOf(2, 3),
                    intArrayOf(1, 4),
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `max points test`(testCase: Pair<Int, Array<IntArray>>) {
        val (expected, points) = testCase
        val actual = points.maxPoints()
        assertEquals(expected, actual)
    }
}

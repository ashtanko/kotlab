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

internal class ValidBoomerangTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, Array<IntArray>>> {
            return listOf(
                true to arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 3),
                    intArrayOf(3, 2)
                ),
                false to arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is boomerang test`(testCase: Pair<Boolean, Array<IntArray>>) {
        val (expected, points) = testCase
        val actual = isBoomerang(points)
        assertEquals(expected, actual)
    }
}

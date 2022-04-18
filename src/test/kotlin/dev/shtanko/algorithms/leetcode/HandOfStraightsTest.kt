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

internal class HandOfStraightsTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Boolean>> {
            return listOf(
                intArrayOf(1, 2, 3, 6, 2, 3, 4, 7, 8) to 3 to true,
                intArrayOf(1, 2, 3, 4, 5) to 4 to false,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is n straight hand test`(testCase: Pair<Pair<IntArray, Int>, Boolean>) {
        val (data, expected) = testCase
        val (hand, w) = data
        val actual = isNStraightHand(hand, w)
        assertEquals(expected, actual)
    }
}

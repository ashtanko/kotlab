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

internal class MajorityCheckerTest {

    private val array = intArrayOf(1, 1, 2, 2, 1, 1)

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Triple<Int, Int, Int>>> {
            return listOf(
                1 to Triple(0, 5, 4),
                -1 to Triple(0, 3, 3),
                2 to Triple(2, 3, 2),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `majority checker test`(testCase: Pair<Int, Triple<Int, Int, Int>>) {
        val (expected, data) = testCase
        val (left, right, threshold) = data
        val actual = MajorityChecker(array).query(left, right, threshold)
        assertEquals(expected, actual)
    }
}

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

package dev.shtanko.dynamicprogramming

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class RodCuttingProblemTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Int>> {
            return listOf(
                intArrayOf(2, 5, 7, 8) to 5 to 12,
                intArrayOf(1, 5, 8, 9, 10, 17, 17, 20) to 4 to 10
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `cut rod test`(testCase: Pair<Pair<IntArray, Int>, Int>) {
        val expected = testCase.second
        val actual = cutRod(testCase.first.first, testCase.first.second)
        assertEquals(expected, actual)
    }
}

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

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class SortColorsTest<out T : SortColorsStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider() = listOf(
            intArrayOf(2, 0, 2, 1, 1, 0) to intArrayOf(0, 0, 1, 1, 2, 2),
            intArrayOf(2, 0, 1) to intArrayOf(0, 1, 2),
            intArrayOf(0) to intArrayOf(0),
            intArrayOf(1) to intArrayOf(1),
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `sort colors test`(testCase: Pair<IntArray, IntArray>) {
        val (arr, expected) = testCase
        strategy.invoke(arr)
        assertArrayEquals(expected, arr)
    }
}

class SortColorsOnePassTest : SortColorsTest<SortColorsOnePass>(SortColorsOnePass())
class SortColorsTwoPassTest : SortColorsTest<SortColorsTwoPass>(SortColorsTwoPass())

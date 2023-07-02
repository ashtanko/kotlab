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

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ElementPositionTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Int, IntArray>, IntArray>> {
            return listOf(
                4 to intArrayOf() to intArrayOf(-1, -1),
                8 to intArrayOf(5, 7, 7, 8, 8, 10) to intArrayOf(3, 4),
                6 to intArrayOf(5, 7, 7, 8, 8, 10) to intArrayOf(-1, -1),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `search range test`(testCase: Pair<Pair<Int, IntArray>, IntArray>) {
        val (data, expected) = testCase
        val (target, arr) = data
        val actual = arr.searchRange(target)
        assertThat(actual, equalTo(expected))
    }
}

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

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class AvoidFloodInTheCityTest<out T : AvoidFloodStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider() = listOf(
            intArrayOf(1, 2, 3, 4) to intArrayOf(-1, -1, -1, -1),
            intArrayOf(1, 2, 0, 0, 2, 1) to intArrayOf(-1, -1, 2, 1, -1, -1),
            intArrayOf(1, 2, 0, 1, 2) to intArrayOf(),
            intArrayOf(69, 0, 0, 0, 69) to intArrayOf(-1, 69, 1, 1, -1),
            intArrayOf(10, 20, 20) to intArrayOf(),
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `avoid flood test`(testCase: Pair<IntArray, IntArray>) {
        val (rains, expected) = testCase
        val actual = strategy.perform(rains)
        assertThat(actual, equalTo(expected))
    }
}

internal class AvoidFloodTreeTest : AvoidFloodInTheCityTest<AvoidFloodTree>(AvoidFloodTree())

internal class AvoidFloodSimpleTest : AvoidFloodInTheCityTest<AvoidFloodSimple>(AvoidFloodSimple())

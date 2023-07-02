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

abstract class JewelsStonesTest<out T : NumJewelsInStonesStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, String>, Int>> = listOf(
            "aA" to "aAAbbbb" to 3,
            "z" to "ZZ" to 0,
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `jewels stones test`(testCase: Pair<Pair<String, String>, Int>) {
        val (data, expected) = testCase
        val (a, b) = data
        val actual = strategy.perform(a, b)
        assertEquals(expected, actual)
    }
}

class NumJewelsInStonesMapTest : JewelsStonesTest<NumJewelsInStonesMap>(NumJewelsInStonesMap())
class NumJewelsInStonesRegexTest : JewelsStonesTest<NumJewelsInStonesRegex>(NumJewelsInStonesRegex())

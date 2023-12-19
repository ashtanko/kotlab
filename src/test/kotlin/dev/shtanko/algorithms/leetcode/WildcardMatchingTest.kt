/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
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

class WildcardMatchingTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, String>, Boolean>> {
            return listOf(
                "aa" to "a" to false,
                "aa" to "*" to true,
                "cb" to "?a" to false,
                "adceb" to "*a*b" to true,
                "acdcb" to "a*c?b" to false,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Pair<String, String>, Boolean>) {
        val (pair, expected) = testCase
        val actual = pair.isMatch()
        assertEquals(expected, actual)
    }
}

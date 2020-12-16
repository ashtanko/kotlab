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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class StringToIntegerTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, Int>> {
            return listOf(
                "" to 0,
                "0" to 0,
                "4" to 4,
                "-3" to -3,
                "435" to 435
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `string to int test`(testCase: Pair<String, Int>) {
        val (str, expected) = testCase
        val actual = str.atoi()
        assertEquals(expected, actual)
    }
}

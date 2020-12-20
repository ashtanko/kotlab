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

internal class StrongPasswordCheckerTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, Int>> {
            return listOf(
                "" to 6,
                "123456" to 2,
                "qwerty" to 2,
                "password123456" to 1,
                "QWERTY" to 2,
                "QWERTYuiopasdfghjkl;'[]zxcvbnm,./." to 15,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `strong password checker test`(testCase: Pair<String, Int>) {
        val (password, expected) = testCase
        val actual = strongPasswordChecker(password)
        assertEquals(expected, actual)
    }
}

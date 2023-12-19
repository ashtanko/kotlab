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

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ReverseStringTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<CharArray, CharArray>> {
            return listOf(
                charArrayOf() to charArrayOf(),
                charArrayOf('h', 'e', 'l', 'l', 'o') to charArrayOf('o', 'l', 'l', 'e', 'h'),
                charArrayOf('T', 'E', 'N', 'E', 'T') to charArrayOf('T', 'E', 'N', 'E', 'T'),
                charArrayOf('2', '1') to charArrayOf('1', '2'),
                charArrayOf('$', '%') to charArrayOf('%', '$'),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `reverse string test`(testCase: Pair<CharArray, CharArray>) {
        val (arr, expected) = testCase
        arr.reverse()
        assertArrayEquals(expected, arr)
    }
}

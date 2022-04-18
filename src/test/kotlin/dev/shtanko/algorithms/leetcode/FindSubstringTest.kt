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

internal abstract class AbstractFindSubstringTest<T : AbstractFindSubstring>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, Array<String>>, List<Int>>> {
            return listOf(
                "" to arrayOf("foo", "bar") to listOf(),
                "barfoothefoobarman" to arrayOf("foo", "bar") to listOf(0, 9),
                "wordgoodgoodgoodbestword" to arrayOf("word", "good", "best", "word") to emptyList(),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `find substring test`(testCase: Pair<Pair<String, Array<String>>, List<Int>>) {
        val (data, expected) = testCase
        val (str, words) = data
        val actual = strategy.perform(str, words)
        assertEquals(expected, actual)
    }
}

internal class FindSubstringTest : AbstractFindSubstringTest<FindSubstring>(FindSubstring())

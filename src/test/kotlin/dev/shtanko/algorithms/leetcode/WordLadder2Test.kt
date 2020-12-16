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

internal abstract class AbstractWordLadder2StrategyTest<out T : AbstractWordLadder2Strategy>(private val strategy: T) {

    data class WordLadderTestCase(
        val beginWord: String,
        val endWord: String,
        val wordList: List<String>,
        val output: List<List<String>>
    )

    companion object {
        @JvmStatic
        fun dataProvider(): List<WordLadderTestCase> {
            return listOf(
                WordLadderTestCase(
                    "hit",
                    "cog",
                    listOf("hot", "dot", "dog", "lot", "log", "cog"),
                    listOf(
                        listOf("hit", "hot", "dot", "dog", "cog"),
                        listOf("hit", "hot", "lot", "log", "cog")
                    )
                ),
                WordLadderTestCase(
                    "hit",
                    "cog",
                    listOf("hot", "dot", "dog", "lot", "log"),
                    emptyList()
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `word ladder 2 test`(testCase: WordLadderTestCase) {
        val (beginWord, endWord, wordList, expected) = testCase
        val actual = strategy.perform(beginWord, endWord, wordList)
        assertEquals(expected, actual)
    }
}

internal class WordLadder2Test : AbstractWordLadder2StrategyTest<WordLadder2>(WordLadder2())

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

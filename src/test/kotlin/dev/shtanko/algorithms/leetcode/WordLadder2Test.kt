package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractWordLadder2StrategyTest<out T : AbstractWordLadder2Strategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val beginWord = "hit"
        val endWord = "cog"
        val wordList = listOf("hot", "dot", "dog", "lot", "log", "cog")
        val expected = listOf(
            listOf("hit", "hot", "dot", "dog", "cog"),
            listOf("hit", "hot", "lot", "log", "cog")
        )
        val actual = strategy.perform(beginWord, endWord, wordList)
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val beginWord = "hit"
        val endWord = "cog"
        val wordList = listOf("hot", "dot", "dog", "lot", "log")
        val expected = listOf<List<String>>()
        val actual = strategy.perform(beginWord, endWord, wordList)
        assertEquals(expected, actual)
    }
}

class WordLadder2Test : AbstractWordLadder2StrategyTest<WordLadder2>(WordLadder2())

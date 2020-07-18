package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractFindSubstringTest<T : AbstractFindSubstring>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val str = "barfoothefoobarman"
        val words = arrayOf("foo", "bar")
        val actual = strategy.perform(str, words)
        val expected = listOf(0, 9)
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val str = "wordgoodgoodgoodbestword"
        val words = arrayOf("word", "good", "best", "word")
        val actual = strategy.perform(str, words)
        val expected = emptyList<Int>()
        assertEquals(expected, actual)
    }
}

class FindSubstringTest : AbstractFindSubstringTest<FindSubstring>(FindSubstring())

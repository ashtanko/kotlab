package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCharactersTest {

    @Test
    fun `simple test`() {
        val words = arrayOf("cat", "bt", "hat", "tree")
        val chars = "atach"
        assertEquals(6, words.countCharacters(chars))
    }

    @Test
    fun `simple test 2`() {
        val words = arrayOf("hello", "world", "leetcode")
        val chars = "welldonehoneyr"
        assertEquals(10, words.countCharacters(chars))
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KeyboardRowTest {

    @Test
    fun `simple test`() {
        val words = arrayOf("Hello", "Alaska", "Dad", "Peace")
        assertArrayEquals(arrayOf("Alaska", "Dad"), words.findWords())
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ReverseStringTest {

    @Test
    fun `empty test`() {
        val arr = charArrayOf()
        arr.reverse()
        assertArrayEquals(charArrayOf(), arr)
    }

    @Test
    fun `simple test`() {
        val arr = charArrayOf('h', 'e', 'l', 'l', 'o')
        arr.reverse()
        assertArrayEquals(charArrayOf('o', 'l', 'l', 'e', 'h'), arr)
    }
}

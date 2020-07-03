package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ReplaceElementsTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(17, 18, 5, 4, 6, 1)
        val expected = intArrayOf(18, 6, 6, 6, 1, -1)
        val actual = arr.replaceElements()
        assertArrayEquals(expected, actual)
    }
}

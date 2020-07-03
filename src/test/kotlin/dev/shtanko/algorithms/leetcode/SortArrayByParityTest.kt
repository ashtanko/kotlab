package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SortArrayByParityTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(3, 1, 2, 4)
        val expected = intArrayOf(4, 2, 1, 3)
        val actual = arr.sortArrayByParity()
        assertArrayEquals(expected, actual)
    }
}

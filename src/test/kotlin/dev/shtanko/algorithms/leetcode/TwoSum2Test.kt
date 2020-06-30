package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TwoSum2Test {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(2, 7, 11, 15)
        val target = 9
        val actual = arr.twoSum2(target)
        val expected = intArrayOf(1, 2)
        assertArrayEquals(expected, actual)
    }
}

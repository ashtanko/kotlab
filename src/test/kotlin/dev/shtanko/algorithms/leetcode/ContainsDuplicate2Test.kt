package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ContainsDuplicate2Test {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 2, 3, 1)
        val k = 3
        assertTrue(arr.isContainsNearbyDuplicate(k))
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 0, 1, 1)
        val k = 1
        assertTrue(arr.isContainsNearbyDuplicate(k))
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(1, 2, 3, 1, 2, 3)
        val k = 2
        assertFalse(arr.isContainsNearbyDuplicate(k))
    }
}

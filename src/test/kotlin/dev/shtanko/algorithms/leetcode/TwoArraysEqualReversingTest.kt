package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TwoArraysEqualReversingTest {

    @Test
    fun `simple test`() {
        val target = intArrayOf(1, 2, 3, 4)
        val arr = intArrayOf(2, 4, 1, 3)
        val actual = (target to arr).canBeEqual()
        assertTrue(actual)
    }

    @Test
    fun `simple test 2`() {
        val target = intArrayOf(7)
        val arr = intArrayOf(7)
        val actual = (target to arr).canBeEqual()
        assertTrue(actual)
    }

    @Test
    fun `simple test 3`() {
        val target = intArrayOf(1, 12)
        val arr = intArrayOf(12, 1)
        val actual = (target to arr).canBeEqual()
        assertTrue(actual)
    }

    @Test
    fun `simple test 4`() {
        val target = intArrayOf(3, 7, 9)
        val arr = intArrayOf(3, 7, 11)
        val actual = (target to arr).canBeEqual()
        assertFalse(actual)
    }

    @Test
    fun `simple test 5`() {
        val target = intArrayOf(1, 1, 1, 1, 1)
        val arr = intArrayOf(1, 1, 1, 1, 1)
        val actual = (target to arr).canBeEqual()
        assertTrue(actual)
    }

    @Test
    fun `simple test 7`() {
        val target = intArrayOf(1, 2, 3, 4)
        val arr = intArrayOf(2, 4, 1, 3)
        val actual = (target to arr).canBeEqualSort()
        assertTrue(actual)
    }

    @Test
    fun `simple test 8`() {
        val target = intArrayOf(7)
        val arr = intArrayOf(7)
        val actual = (target to arr).canBeEqualSort()
        assertTrue(actual)
    }

    @Test
    fun `simple test 9`() {
        val target = intArrayOf(1, 12)
        val arr = intArrayOf(12, 1)
        val actual = (target to arr).canBeEqualSort()
        assertTrue(actual)
    }

    @Test
    fun `simple test 10`() {
        val target = intArrayOf(3, 7, 9)
        val arr = intArrayOf(3, 7, 11)
        val actual = (target to arr).canBeEqualSort()
        assertFalse(actual)
    }

    @Test
    fun `simple test 11`() {
        val target = intArrayOf(1, 1, 1, 1, 1)
        val arr = intArrayOf(1, 1, 1, 1, 1)
        val actual = (target to arr).canBeEqualSort()
        assertTrue(actual)
    }
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JewelsStonesTest {

    @Test
    fun `simple test`() {
        val actual = ("aA" to "aAAbbbb").numJewelsInStones()
        assertEquals(3, actual)
    }

    @Test
    fun `simple test 2`() {
        val actual = ("z" to "ZZ").numJewelsInStones()
        assertEquals(0, actual)
    }

    @Test
    fun `simple test 3`() {
        val actual = ("aA" to "aAAbbbb").numJewelsInStonesRegex()
        assertEquals(3, actual)
    }

    @Test
    fun `simple test 4`() {
        val actual = ("z" to "ZZ").numJewelsInStonesRegex()
        assertEquals(0, actual)
    }
}

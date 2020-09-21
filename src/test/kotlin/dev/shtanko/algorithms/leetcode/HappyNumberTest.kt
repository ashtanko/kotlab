package dev.shtanko.algorithms.leetcode

import dev.shtanko.kotlinlang.inline.each
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class HappyNumberTest {

    @Test
    fun `simple test`() {
        assertTrue(19.isHappy())
    }

    @Test
    fun `simple test 2`() {
        assertFalse(16.isHappy())
    }

    @Test
    fun `simple test 3`() {
        val happyList = mutableListOf<Int>()
        listOf(4, 8, 15, 16, 23, 42).each {
            if (it.isHappy()) {
                happyList.add(it)
            }
        }
        assertEquals(23, happyList.first())
    }

    @Test
    fun `simple test 4`() {
        val happyList = mutableListOf<Int>()
        repeat(25) {
            if (it.isHappy()) {
                happyList.add(it)
            }
        }
        assertEquals(listOf(1, 7, 10, 13, 19, 23), happyList)
    }
}

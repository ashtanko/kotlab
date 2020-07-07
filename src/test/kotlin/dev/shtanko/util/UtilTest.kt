package dev.shtanko.util

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UtilTest {

    @Test
    fun `list of int equals test`() {
        val list1 = listOf(1, 3, 2)
        val list2 = listOf(1, 3, 2)
        assertTrue(assertListEquals(list1, list2))
    }

    @Test
    fun `list of string equals test`() {
        val list1 = listOf("a", "c", "b")
        val list2 = listOf("a", "c", "b")
        assertTrue(assertListEquals(list1, list2))
    }

    @Test
    fun `list of string equals diff order test`() {
        val list1 = listOf("a", "c", "b")
        val list2 = listOf("a", "b", "c")
        assertTrue(assertListEquals(list1, list2))
    }

    @Test
    fun `not equals test`() {
        val list1 = listOf("a", "c", "b")
        val list2 = listOf("a", "b", "c", "d")
        assertFalse(assertListEquals(list1, list2))
    }

    @Test
    fun `not equals int test`() {
        val list1 = listOf(1, 1, 2)
        val list2 = listOf(1, 3, 2)
        assertFalse(assertListEquals(list1, list2))
    }
}

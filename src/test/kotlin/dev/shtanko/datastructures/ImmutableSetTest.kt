package dev.shtanko.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ImmutableSetTest {

    @Test
    fun `simple test`() {
        assertFalse(immutableSetOf(3).contains(1))
        assertFalse(immutableSetOf(3).contains(2))
        assertFalse(immutableSetOf(3).contains(4))
        assertFalse(immutableSetOf(3).contains(5))
        assertTrue(immutableSetOf(3).contains(3))
    }

    @Test
    fun `simple test 2`() {
        val set = immutableSetOf(*(10 downTo 1).toList().toTypedArray())
        for (v in set) {
            assertTrue(set.contains(v))
        }
        assertEquals(10, set.size)
        assertFalse(set.isEmpty())
        assertFalse(set.contains(42))
        assertFalse(set.contains(-42))
    }

    @Test
    fun `simple test 3`() {
        val set = immutableSetOf(*(0..100).toList().toTypedArray())
        for (v in -100..-1) {
            assertFalse(set.contains(v))
        }
        for (v in 0..100) {
            assertTrue(set.contains(v))
        }
        for (v in 101..200) {
            assertFalse(set.contains(v))
        }
    }
}

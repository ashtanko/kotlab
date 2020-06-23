package dev.shtanko.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DisjointSetTest {

    @Test
    fun `size test`() {
        val set = DisjointSet(10)
        assertEquals(10, set.count)
        assertEquals(10, set.size)
        set.union(0, 1)
        assertEquals(9, set.count)
        assertEquals(10, set.size)
        set.union(0, 2)
        assertEquals(8, set.count)
        assertEquals(10, set.size)
    }

    @Test
    fun `naive test`() {
        val set = DisjointSet(10)
        for (i in 1 until set.size) {
            assertFalse(set.connected(i, i - 1))
        }
        set.union(1, 2)
        assertTrue(set.connected(1, 2))
        set.union(1, 3)
        assertTrue(set.connected(1, 3))
        assertTrue(set.connected(2, 3))
        set.union(3, 4)
        assertTrue(set.connected(2, 4))
        assertFalse(set.connected(0, 1))
        assertFalse(set.connected(0, 5))
        assertFalse(set.connected(4, 5))
    }
}

package dev.shtanko.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IntMapTest {

    @Test
    fun `empty test`() {
        val map = IntMap<String>()
        assertTrue(map.isEmpty())
    }

    @Test
    fun `get test`() {
        val map = IntMap<String>()
        map.put(1, "Apple")
        map.put(2, "Banana")
        assertEquals("Apple", map[1])
        assertEquals("Banana", map[2])
        assertEquals(null, map[3])
    }

    @Test
    fun `indexOfKey test`() {
        val map = IntMap<String>()
        map.put(1, "Apple")
        map.put(2, "Banana")
        assertEquals(0, map.indexOfKey(1))
        assertEquals(1, map.indexOfKey(2))
        assertEquals(-3, map.indexOfKey(3))
    }

    @Test
    fun `containsKey test`() {
        val map = IntMap<String>()
        map.put(1, "Apple")
        map.put(2, "Banana")
        assertTrue(map.containsKey(1))
        assertTrue(map.containsKey(2))
        assertFalse(map.containsKey(3))
    }

    @Test
    fun `valueAt test`() {
        val map = IntMap<String>()
        map.put(1, "Apple")
        map.put(2, "Banana")
        assertEquals("Apple", map.valueAt(0))
        assertEquals("Banana", map.valueAt(1))
        assertEquals(null, map.valueAt(3))
    }

    @Test
    fun `keyAt test`() {
        val map = IntMap<String>()
        map.put(1, "Apple")
        map.put(2, "Banana")
        assertEquals(1, map.keyAt(0))
        assertEquals(2, map.keyAt(1))
        assertEquals(0, map.keyAt(3))
    }

    @Test
    fun `setValueAt test`() {
        val map = IntMap<String>()
        map.put(1, "Apple")
        map.put(2, "Banana")

        map.setValueAt(0, "Array")
        assertEquals("Array", map[1])
        assertEquals("Banana", map[2])
    }

    @Test
    fun `delete test`() {
        val map = IntMap<String>()
        map.put(1, "Apple")
        map.put(2, "Banana")
        map.delete(1)

        map.setValueAt(0, "Array")
        assertFalse(map.containsKey(1))
        assertTrue(map.containsKey(2))
    }
}

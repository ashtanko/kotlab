package dev.shtanko.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ArrayMapTest {

    @Test
    fun `empty test`() {
        val map = ArrayMap<String, String>()
        assertTrue(map.isEmpty())
    }

    @Test
    fun `put test`() {
        val map = ArrayMap<String, String>()
        map.put("A", "Apple")
        map.put("B", "Banana")
        assertEquals("Apple", map["A"])
        assertEquals("Banana", map["B"])
        assertEquals(null, map["D"])
    }

    @Test
    fun `indexOfKey test`() {
        val map = ArrayMap<String, String>()
        map.put("A", "Apple")
        map.put("B", "Banana")
        assertEquals(0, map.indexOfKey("A"))
        assertEquals(1, map.indexOfKey("B"))
        assertEquals(-3, map.indexOfKey("D"))
    }

    @Test
    fun `containsKey test`() {
        val map = ArrayMap<String, String>()
        map.put("A", "Apple")
        map.put("B", "Banana")
        assertTrue(map.containsKey("A"))
        assertTrue(map.containsKey("B"))
        assertFalse(map.containsKey("D"))
    }

    @Test
    fun `valueAt test`() {
        val map = ArrayMap<String, String>()
        map.put("A", "Apple")
        map.put("B", "Banana")
        assertEquals("Apple", map.valueAt(0))
        assertEquals("Banana", map.valueAt(1))
        assertEquals(null, map.valueAt(2))
    }

    @Test
    fun `keyAt test`() {
        val map = ArrayMap<String, String>()
        map.put("A", "Apple")
        map.put("B", "Banana")
        assertEquals("A", map.keyAt(0))
        assertEquals("B", map.keyAt(1))
        assertEquals(null, map.keyAt(2))
    }

    @Test
    fun `setValueAt test`() {
        val map = ArrayMap<String, String>()
        map.put("A", "Apple")
        map.put("B", "Banana")

        map.setValueAt(0, "Array")
        assertEquals("Array", map["A"])
        assertEquals("Banana", map["B"])
    }

    @Test
    fun `remove test`() {
        val map = ArrayMap<String, String>()
        map.put("A", "Apple")
        map.put("B", "Banana")

        map.remove("A")
        assertFalse(map.containsKey("A"))
        assertTrue(map.containsKey("B"))
    }
}

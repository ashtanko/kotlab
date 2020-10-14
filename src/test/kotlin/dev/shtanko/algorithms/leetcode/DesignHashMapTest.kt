package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignHashMapTest {

    @Test
    fun `hash map behavioral test`() {
        val map = DesignHashMap()
        map.put(1, 1)
        map.put(2, 2)
        assertEquals(1, map.get(1))
        assertEquals(-1, map.get(3))
        map.put(2, 1)
        assertEquals(1, map.get(2))
        map.remove(2)
        assertEquals(-1, map.get(2))
    }
}

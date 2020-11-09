package dev.shtanko.oop

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.TreeSet

class CompositionSolutionTest {
    @Test
    fun `composition instrumented hash set test`() {
        val s = CompositionInstrumentedHashSet<String>(TreeSet())
        s.addAll(listOf("Snap", "Crackle", "Pop"))
        val actual = s.getAddCount()
        assertEquals(3, actual) // Right value is 3, composition working correctly
    }
}

package dev.shtanko.oop

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class InheritanceViolationTest {

    @Test
    internal fun `inheritance instrumented hash set test`() {
        val s = InheritanceInstrumentedHashSet<String>()
        s.addAll(listOf("Snap", "Crackle", "Pop"))
        val actual = s.getAddCount()
        assertEquals(6, actual) // Should be 3
    }
}

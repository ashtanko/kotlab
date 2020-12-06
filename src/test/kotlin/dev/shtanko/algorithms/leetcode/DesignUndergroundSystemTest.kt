package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal abstract class DesignUndergroundSystemTest<out T : UndergroundSystem>(private val system: T) {

    @Test
    fun `underground system test`() {
        system.checkIn(45, "Leyton", 3)
        system.checkIn(32, "Paradise", 8)
        system.checkIn(27, "Leyton", 10)
        system.checkOut(45, "Waterloo", 15)
        system.checkOut(27, "Waterloo", 20)
        system.checkOut(32, "Cambridge", 22)
        assertEquals(14.000, system.getAverageTime("Paradise", "Cambridge"))
        assertEquals(11.000, system.getAverageTime("Leyton", "Waterloo"))
        system.checkIn(10, "Leyton", 24)
        assertEquals(11.000, system.getAverageTime("Leyton", "Waterloo"))
        system.checkOut(10, "Waterloo", 38)
        assertEquals(12.000, system.getAverageTime("Leyton", "Waterloo"))
    }
}

internal class UndergroundSystemImplTest : DesignUndergroundSystemTest<UndergroundSystemImpl>(UndergroundSystemImpl())

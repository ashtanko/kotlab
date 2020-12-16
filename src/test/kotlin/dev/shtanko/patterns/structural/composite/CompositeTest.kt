package dev.shtanko.patterns.structural.composite

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Cabbinet : Composite("cabbinet")
class FloppyDisk : Equipment(70, "Floppy Disk")
class HardDrive : Equipment(250, "Hard Drive")
class Memory : Equipment(280, "Memory")

internal class CompositeTest {

    @Test
    internal fun `composite pattern test`() {
        val cabbinet = Cabbinet()
        cabbinet.add(FloppyDisk())
        cabbinet.add(HardDrive())
        cabbinet.add(Memory())
        val expected = 600
        val actual = cabbinet.getPrice()
        assertEquals(expected, actual)
    }
}

package dev.shtanko.patterns.structural.proxy

import dev.shtanko.kotlinlang.inline.each
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WizardTest {

    @Test
    fun `test wizard name`() {
        listOf("Gandalf", "Dumbledore", "Oz", "Merlin").each { name ->
            assertEquals(name, Wizard(name).toString())
        }
    }
}

package dev.shtanko.patterns.structural.proxy

import dev.shtanko.kotlinlang.inline.each
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class WizardTest {

    @Test
    internal fun `test wizard name`() {
        listOf("Gandalf", "Dumbledore", "Oz", "Merlin").each { name ->
            assertThat(name, equalTo(Wizard(name).toString()))
        }
    }
}

package dev.shtanko.patterns.structural.proxy

import dev.shtanko.kotlinlang.inline.each
import dev.shtanko.patterns.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WizardTowerProxyTest {
    private lateinit var appender: InMemoryAppender

    @BeforeEach
    fun setUp() {
        appender = InMemoryAppender()
    }

    @AfterEach
    fun tearDown() {
        appender.stop()
    }

    @Test
    fun `enter test`() {
        val wizards = listOf(
            Wizard("Gandalf"),
            Wizard("Dumbledore"),
            Wizard("Oz"),
            Wizard("Merlin")
        )
        val proxy = WizardTowerProxy(IvoryTower())
        wizards.each(proxy::enter)
        Assertions.assertTrue(appender.logContains("Gandalf enters the tower."))
        Assertions.assertTrue(appender.logContains("Dumbledore enters the tower."))
        Assertions.assertTrue(appender.logContains("Oz enters the tower."))
        Assertions.assertTrue(appender.logContains("Merlin is not allowed to enter!"))
        Assertions.assertEquals(4, appender.logSize)
    }
}

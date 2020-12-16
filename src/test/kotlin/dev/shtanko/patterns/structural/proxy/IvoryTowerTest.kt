package dev.shtanko.patterns.structural.proxy

import dev.shtanko.kotlinlang.inline.each
import dev.shtanko.patterns.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class IvoryTowerTest {
    private lateinit var appender: InMemoryAppender

    @BeforeEach
    fun setUp() {
        appender = InMemoryAppender(IvoryTower::class.java)
    }

    @AfterEach
    fun tearDown() {
        appender.stop()
    }

    @Test
    internal fun `enter wizard test`() {
        val wizards = listOf(
            Wizard("Gandalf"),
            Wizard("Dumbledore"),
            Wizard("Oz"),
            Wizard("Merlin")
        )
        val tower = IvoryTower()
        wizards.each(tower::enter)
        assertTrue(appender.logContains("Gandalf enters the tower."))
        assertTrue(appender.logContains("Dumbledore enters the tower."))
        assertTrue(appender.logContains("Oz enters the tower."))
        assertTrue(appender.logContains("Merlin enters the tower."))
        assertEquals(4, appender.logSize)
    }
}

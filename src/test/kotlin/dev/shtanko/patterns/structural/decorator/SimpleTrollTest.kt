package dev.shtanko.patterns.structural.decorator

import dev.shtanko.patterns.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SimpleTrollTest {

    private lateinit var appender: InMemoryAppender

    @BeforeEach
    fun setUp() {
        appender = InMemoryAppender(SimpleTroll::class.java)
    }

    @AfterEach
    fun tearDown() {
        appender.stop()
    }

    @Test
    fun `troll actions test`() {
        val troll = SimpleTroll()
        assertEquals(10, troll.getAttackPower())
        troll.attack()
        assertEquals("The troll tries to grab you!", appender.lastMessage)

        troll.fleeBattle()
        assertEquals("The troll shrieks in horror and runs away!", appender.lastMessage)
        assertEquals(2, appender.logSize)
    }
}

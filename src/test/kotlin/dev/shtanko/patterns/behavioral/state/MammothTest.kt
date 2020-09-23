package dev.shtanko.patterns.behavioral.state

import dev.shtanko.patterns.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MammothTest {

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
    fun `time passes test`() {
        val mammoth = Mammoth()
        mammoth.observe()
        assertEquals("The mammoth is calm and peaceful.", appender.lastMessage)
        assertEquals(1, appender.logSize)

        mammoth.timePasses()
        assertEquals("The mammoth gets angry!", appender.lastMessage)
        assertEquals(2, appender.logSize)

        mammoth.observe()
        assertEquals("The mammoth is furious!", appender.lastMessage)
        assertEquals(3, appender.logSize)

        mammoth.timePasses()
        assertEquals("The mammoth calms down.", appender.lastMessage)
        assertEquals(4, appender.logSize)

        mammoth.observe()
        assertEquals("The mammoth is calm and peaceful.", appender.lastMessage)
        assertEquals(5, appender.logSize)
    }

    @Test
    fun `to string test`() {
        val str = Mammoth().toString()
        assertNotNull(str)
        assertEquals("The mammoth", str)
    }
}

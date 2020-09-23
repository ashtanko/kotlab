package dev.shtanko.patterns.solid.srp

import dev.shtanko.patterns.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SingleResponsibilityPrincipleTest {

    val robot = SingleResponsibilityPrinciple.Robot("Wally", "Cleaner")

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
    fun `when violation test`() {
        robot.greet()
        assertEquals("Hello my name is Wally, and I am a Cleaner robot", appender.lastMessage)
    }

    @Test
    fun `when solution test`() {
        val robotPrinter = SingleResponsibilityPrinciple.RobotPrinter()
        robotPrinter.greet(robot)
        assertEquals("Hello my name is Wally, and I am a Cleaner robot", appender.lastMessage)
    }
}

package dev.shtanko.patterns.structural.composite

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MessengerTest {

    private var stdOutBuffer = ByteArrayOutputStream()
    private val realStdOut: PrintStream = System.out

    @BeforeEach
    fun setUp() {
        this.stdOutBuffer = ByteArrayOutputStream()
        System.setOut(PrintStream(stdOutBuffer))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(realStdOut)
    }

    @Test
    fun `message from Orcs test`() {
        val messenger = Messenger()
        testMessage(
            messenger.messageFromOrcs(),
            "Where there is a whip there is a way."
        )
    }

    @Test
    fun `message from Elves test`() {
        val messenger = Messenger()
        testMessage(
            messenger.messageFromElves(),
            "Much wind pours from your mouth."
        )
    }

    private fun testMessage(composedMessage: LetterComposite, message: String) {
        val words = message.split(" ".toRegex())
        assertEquals(words.size, composedMessage.count())
        composedMessage.print()
        assertEquals(message, String(this.stdOutBuffer.toByteArray()).trim())
    }
}

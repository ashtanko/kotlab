package dev.shtanko.patterns.structural.bridge

import dev.shtanko.patterns.structural.bridge.example.EmailMessage
import dev.shtanko.patterns.structural.bridge.example.EmailMessageSender
import dev.shtanko.patterns.structural.bridge.example.TextMessage
import dev.shtanko.patterns.structural.bridge.example.TextMessageSender
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BridgeTest {
    @Test
    fun `simple test`() {
        val textMessageSender = TextMessageSender()
        val textMessage = TextMessage(textMessageSender)
        assertEquals("text", textMessage.send())

        val emailMessageSender = EmailMessageSender()
        val emailMessage = EmailMessage(emailMessageSender)
        assertEquals("email", emailMessage.send())
    }
}

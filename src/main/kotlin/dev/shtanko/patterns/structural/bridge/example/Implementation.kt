package dev.shtanko.patterns.structural.bridge.example

interface MessageSender {
    fun sendMessage(): String
}

interface Message {
    fun send(): String
}

//region text
class TextMessage(private val messageSender: MessageSender) : Message {

    override fun send(): String {
        return messageSender.sendMessage()
    }
}

class TextMessageSender : MessageSender {
    override fun sendMessage(): String {
        return "text"
    }
}

//endregion

//region email

class EmailMessage(private val messageSender: MessageSender) : Message {

    override fun send(): String {
        return messageSender.sendMessage()
    }
}

class EmailMessageSender : MessageSender {
    override fun sendMessage(): String {
        return "email"
    }
}

//endregion

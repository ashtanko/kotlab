package dev.shtanko.patterns.utils

import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.AppenderBase
import org.slf4j.LoggerFactory
import java.util.LinkedList

class InMemoryAppender(clazz: Class<*>? = null) : AppenderBase<ILoggingEvent>() {

    private val log: MutableList<ILoggingEvent> = LinkedList()

    val lastMessage: String
        get() = log[log.size - 1].message

    val logSize: Int
        get() = log.size

    fun logContains(message: String): Boolean {
        return log.map {
            it.formattedMessage
        }.contains(message)
    }

    init {
        if (clazz == null) {
            (LoggerFactory.getLogger("root") as Logger).addAppender(this)
        } else {
            (LoggerFactory.getLogger(clazz) as Logger).addAppender(this)
        }

        start()
    }

    override fun append(eventObject: ILoggingEvent) {
        log.add(eventObject)
    }
}

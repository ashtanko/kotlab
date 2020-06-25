package dev.shtanko.patterns.utils

import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.AppenderBase
import org.slf4j.LoggerFactory
import java.util.LinkedList

class InMemoryAppender(clazz: Class<*>?) : AppenderBase<ILoggingEvent>() {
    private val log: MutableList<ILoggingEvent> = LinkedList()
    override fun append(eventObject: ILoggingEvent) {
        log.add(eventObject)
    }

    val lastMessage: String
        get() = log[log.size - 1].message

    val logSize: Int
        get() = log.size

    init {
        (LoggerFactory.getLogger(clazz) as Logger).addAppender(this)
        start()
    }
}

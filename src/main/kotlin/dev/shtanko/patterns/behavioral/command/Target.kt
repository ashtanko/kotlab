package dev.shtanko.patterns.behavioral.command

import org.slf4j.LoggerFactory

interface Target {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(Target::class.java)
    }

    var size: Size

    var visibility: Visibility

    fun printStatus() {
        LOGGER.info("{}, [size={}] [visibility={}]", this, size, visibility)
    }
}

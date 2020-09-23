package dev.shtanko.patterns.behavioral.state

import org.slf4j.LoggerFactory

class AngryState(private val mammoth: Mammoth) : State {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(AngryState::class.java)
    }

    override fun onEnterState() {
        LOGGER.info("$mammoth gets angry!")
    }

    override fun observe() {
        LOGGER.info("$mammoth is furious!")
    }
}

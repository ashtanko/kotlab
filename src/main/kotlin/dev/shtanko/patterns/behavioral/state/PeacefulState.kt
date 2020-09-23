package dev.shtanko.patterns.behavioral.state

import org.slf4j.LoggerFactory

class PeacefulState(private val mammoth: Mammoth) : State {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(PeacefulState::class.java)
    }

    override fun onEnterState() {
        LOGGER.info("$mammoth calms down.")
    }

    override fun observe() {
        LOGGER.info("$mammoth is calm and peaceful.")
    }
}

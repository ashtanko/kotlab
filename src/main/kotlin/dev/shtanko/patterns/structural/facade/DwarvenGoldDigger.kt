package dev.shtanko.patterns.structural.facade

import dev.shtanko.patterns.structural.adapter.FishingBoat
import org.slf4j.LoggerFactory

class DwarvenGoldDigger : DwarvenMineWorker() {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(FishingBoat::class.java)
    }

    override fun work() {
        LOGGER.info("{} digs for gold.", name())
    }

    override fun name(): String {
        return "Dwarf gold digger"
    }
}

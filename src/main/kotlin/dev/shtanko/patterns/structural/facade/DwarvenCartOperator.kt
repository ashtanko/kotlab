package dev.shtanko.patterns.structural.facade

import dev.shtanko.patterns.structural.adapter.FishingBoat
import org.slf4j.LoggerFactory

class DwarvenCartOperator : DwarvenMineWorker() {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(FishingBoat::class.java)
    }

    override fun work() {
        LOGGER.info("{} moves gold chunks out of the mine.", name())
    }

    override fun name(): String {
        return "Dwarf cart operator"
    }
}

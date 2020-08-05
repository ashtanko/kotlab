package dev.shtanko.patterns.structural.facade

import dev.shtanko.patterns.structural.adapter.FishingBoat
import org.slf4j.LoggerFactory

class DwarvenTunnelDigger : DwarvenMineWorker() {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(FishingBoat::class.java)
    }

    override fun work() {
        LOGGER.info("{} creates another promising tunnel.", name())
    }

    override fun name(): String {
        return "Dwarven tunnel digger"
    }
}

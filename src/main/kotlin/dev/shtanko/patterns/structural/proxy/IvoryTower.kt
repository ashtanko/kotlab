package dev.shtanko.patterns.structural.proxy

import org.slf4j.LoggerFactory

class IvoryTower : WizardTower {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(IvoryTower::class.java)
    }

    override fun enter(wizard: Wizard) {
        LOGGER.info("{} enters the tower.", wizard)
    }
}

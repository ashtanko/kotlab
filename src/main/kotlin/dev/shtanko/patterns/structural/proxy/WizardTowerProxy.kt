package dev.shtanko.patterns.structural.proxy

import org.slf4j.LoggerFactory

class WizardTowerProxy(private val tower: WizardTower) : WizardTower {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(WizardTowerProxy::class.java)
        private const val NUM_WIZARDS_ALLOWED = 3
    }

    private var numWizards: Int = 0

    override fun enter(wizard: Wizard) {
        if (numWizards < NUM_WIZARDS_ALLOWED) {
            tower.enter(wizard)
            numWizards++
        } else {
            LOGGER.info("{} is not allowed to enter!", wizard)
        }
    }
}

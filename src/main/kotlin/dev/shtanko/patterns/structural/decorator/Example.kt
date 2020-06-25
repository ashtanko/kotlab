package dev.shtanko.patterns.structural.decorator

import org.slf4j.LoggerFactory

interface Troll {
    fun attack()

    fun getAttackPower(): Int

    fun fleeBattle()
}

class SimpleTroll : Troll {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(SimpleTroll::class.java)
        private const val TROLL_ATTACK_POWER = 10
    }

    override fun attack() {
        LOGGER.info("The troll tries to grab you!")
    }

    override fun getAttackPower(): Int {
        return TROLL_ATTACK_POWER
    }

    override fun fleeBattle() {
        LOGGER.info("The troll shrieks in horror and runs away!")
    }
}

class ClubbedTroll(private val decorated: Troll) : Troll {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ClubbedTroll::class.java)
        private const val TROLL_ATTACK_POWER = 10
    }

    override fun attack() {
        decorated.attack()
        LOGGER.info("The troll swings at you with a club!")
    }

    override fun getAttackPower(): Int {
        return decorated.getAttackPower() + TROLL_ATTACK_POWER
    }

    override fun fleeBattle() {
        decorated.fleeBattle()
    }
}

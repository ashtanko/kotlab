package dev.shtanko.patterns.structural.facade

import dev.shtanko.patterns.structural.adapter.FishingBoat
import org.slf4j.LoggerFactory

abstract class DwarvenMineWorker {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(FishingBoat::class.java)
    }

    private fun goToSleep() {
        LOGGER.info("{} goes to sleep.", name())
    }

    private fun wakeUp() {
        LOGGER.info("{} wakes up.", name())
    }

    fun goHome() {
        LOGGER.info("{} goes home.", name())
    }

    fun goToMine() {
        LOGGER.info("{} goes to the mine.", name())
    }

    fun performActions(vararg actions: Action) {
        actions.forEach {
            performAction(it)
        }
    }

    abstract fun work()

    abstract fun name(): String

    private fun performAction(action: Action) {
        when (action) {
            is Action.GoToSleep -> {
                goToSleep()
            }
            is Action.WakeUp -> {
                wakeUp()
            }

            is Action.GoHome -> {
                goHome()
            }

            is Action.GoToMine -> {
                goToMine()
            }

            is Action.Work -> {
                work()
            }
        }
    }

    sealed class Action {
        object GoToSleep : Action()
        object WakeUp : Action()
        object GoHome : Action()
        object GoToMine : Action()
        object Work : Action()
    }
}

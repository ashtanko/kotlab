package dev.shtanko.patterns.structural.facade

class DwarvenGoldmineFacade {

    private val workers: List<DwarvenMineWorker> = listOf(
        DwarvenGoldDigger(),
        DwarvenCartOperator(),
        DwarvenTunnelDigger()
    )

    fun startNewDay() {
        makeActions(workers, DwarvenMineWorker.Action.WakeUp, DwarvenMineWorker.Action.GoToMine)
    }

    fun digOutGold() {
        makeActions(workers, DwarvenMineWorker.Action.Work)
    }

    fun endDay() {
        makeActions(workers, DwarvenMineWorker.Action.GoHome, DwarvenMineWorker.Action.GoToSleep)
    }

    @Suppress("SpreadOperator")
    private fun makeActions(
        workers: Collection<DwarvenMineWorker>,
        vararg actions: DwarvenMineWorker.Action
    ) {
        workers.forEach {
            it.performActions(*actions)
        }
    }
}

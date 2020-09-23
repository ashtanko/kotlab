package dev.shtanko.patterns.behavioral.state

interface State {
    fun onEnterState()

    fun observe()
}

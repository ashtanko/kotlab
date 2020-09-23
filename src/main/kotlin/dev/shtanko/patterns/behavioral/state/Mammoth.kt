package dev.shtanko.patterns.behavioral.state

class Mammoth {

    private var state: State = PeacefulState(this)

    override fun toString() = "The mammoth"

    fun timePasses() {
        if (state is PeacefulState) {
            changeStateTo(AngryState(this))
        } else {
            changeStateTo(PeacefulState(this))
        }
    }

    fun observe() {
        this.state.observe()
    }

    private fun changeStateTo(newState: State) {
        this.state = newState
        this.state.onEnterState()
    }
}

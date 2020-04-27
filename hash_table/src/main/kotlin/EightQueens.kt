import java.util.LinkedList
import kotlin.math.abs

class Queens constructor(private val n: Int) {

    private var state = LinkedList<Int>()

    private fun isValid(state: LinkedList<Int>): Boolean {
        if (state.size == 1) return true

        val stateSize = state.size - 1
        val lastX = stateSize
        val lastY = state[lastX]
        for (i in state.indices) {

            //check horizontal conflict while we are at it:
            if (state.last == state[i]) return false

            val xdiff = abs(lastX - i)
            val ydiff = abs(lastY - state[i])

            if (xdiff == ydiff) return false
        }

        return true
    }

    private fun compute(state: LinkedList<Int>?): LinkedList<Int>? {
        if (state == null) return null
        if (this.n == state.size) {
            return state
        }

        for (i in 0 until n) {

            //push i onto the stack
            state.add(i)

            //check if placement onto stack is valid according to game rules
            if (isValid(state)) {
                //if the placement is valid, we need to try to place something in the next column
                val tmp = this.compute(state)
                //if compute returns something non null, then we have reached a valid configuration
                //and must return it back up the stack.
                if (tmp != null) return tmp
            } else {
                //if tmp is null here, then we have hit a "wall" and must backtrack
                state.removeLast()
            }
        }

        /*
        If we reach this point, then we need to backtrack.
        */
        return state
    }

    fun toStr(): String {

        if (this.state.isEmpty() || this.state.size == 1) return "state is empty or 1"
        val sb = StringBuffer()

        sb.append(this.state.toString())

        for (i in 0 until n) {
            sb.append("\n")
            for (j in 0 until n) {
                if (this.state[i] == j) {
                    sb.append("| Q")
                } else {
                    sb.append("| ")
                }
            }
            sb.append("|")
        }

        return sb.toString()
    }

    fun solve() {
        val s = compute(LinkedList<Int>())
        s?.let {
            this.state = it
        }
    }
}

fun main() {
    val queens = Queens(8)
    queens.solve()

    println(queens.toStr())
}
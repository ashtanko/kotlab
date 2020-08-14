package dev.shtanko.patterns.behavioral.command

import org.slf4j.LoggerFactory
import java.util.Deque
import java.util.LinkedList

class Wizard {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(Wizard::class.java)
    }

    private val undoStack: Deque<Command> = LinkedList()
    private val redoStack: Deque<Command> = LinkedList()

    fun castSpell(command: Command, target: Target) {
        LOGGER.info("{} casts {} at {}", this, command, target)
        command.execute(target)
        undoStack.offerLast(command)
    }

    fun undoLastSpell() {
        if (!undoStack.isEmpty()) {
            val previousSpell = undoStack.pollLast()
            redoStack.offerLast(previousSpell)
            LOGGER.info("{} undoes {}", this, previousSpell)
            previousSpell.undo()
        }
    }

    fun redoLastSpell() {
        if (!redoStack.isEmpty()) {
            val previousSpell = redoStack.pollLast()
            undoStack.offerLast(previousSpell)
            LOGGER.info("{} redoes {}", this, previousSpell)
            previousSpell.redo()
        }
    }

    override fun toString(): String {
        return "Wizard"
    }
}

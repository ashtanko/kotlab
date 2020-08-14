package dev.shtanko.patterns.behavioral.command

interface Command {

    fun execute(target: Target)

    fun undo()

    fun redo()
}

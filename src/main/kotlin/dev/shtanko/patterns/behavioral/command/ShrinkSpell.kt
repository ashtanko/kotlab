package dev.shtanko.patterns.behavioral.command

class ShrinkSpell : Command {

    private lateinit var oldSize: Size

    private lateinit var target: Target

    override fun execute(target: Target) {
        oldSize = target.size
        target.size = Size.SMALL
        this.target = target
    }

    override fun undo() {
        val temp = target.size
        target.size = oldSize
        oldSize = temp
    }

    override fun redo() {
        undo()
    }
}

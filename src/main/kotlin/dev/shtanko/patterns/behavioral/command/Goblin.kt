package dev.shtanko.patterns.behavioral.command

class Goblin(
    override var size: Size = Size.NORMAL,
    override var visibility: Visibility = Visibility.VISIBLE
) : Target {
    override fun toString(): String {
        return "Goblin"
    }
}

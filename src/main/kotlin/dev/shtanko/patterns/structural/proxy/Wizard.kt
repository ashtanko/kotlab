package dev.shtanko.patterns.structural.proxy

data class Wizard(val name: String) {
    override fun toString(): String {
        return name
    }
}

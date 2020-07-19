package dev.shtanko.concurrency.coroutines.flow

private fun foo(): List<Int> = listOf(1, 2, 3)

fun main() {
    foo().forEach { value -> println(value) }
}

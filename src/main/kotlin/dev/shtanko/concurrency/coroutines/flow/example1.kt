package dev.shtanko.concurrency.coroutines.flow

fun example1Foo(): List<Int> = listOf(1, 2, 3)

fun main() {
    example1Foo().forEach { value -> println(value) }
}

package dev.shtanko.concurrency.coroutines.flow

private const val DELAY = 300L

private fun foo(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(DELAY) // pretend we are computing it
        yield(i) // yield next value
    }
}

fun main() {
    foo().forEach { value -> println(value) }
}

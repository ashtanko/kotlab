package dev.shtanko.concurrency.coroutines.flow

private const val DELAY = 300L

fun example2Foo(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(DELAY) // pretend we are computing it
        yield(i) // yield next value
    }
}

fun main() {
    example2Foo().forEach { value -> println(value) }
}

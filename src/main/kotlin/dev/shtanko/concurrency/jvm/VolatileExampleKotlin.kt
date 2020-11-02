package dev.shtanko.concurrency.jvm

import kotlin.concurrent.thread

private const val SLEEP_TIME_MILLIS = 100L

class VolatileExampleKotlin {

    @Volatile
    private var running = false

    fun start() {
        running = true
        thread(start = true) {
            while (running) {
                println("Still running: ${Thread.currentThread()}")
            }
        }
    }

    fun stop() {
        running = false
        println("Stopped: ${Thread.currentThread()}")
    }
}

fun main() {
    println("starting: " + Thread.currentThread())

    val example = VolatileExampleKotlin()

    example.start()

    Thread.sleep(SLEEP_TIME_MILLIS)

    example.stop()

    println("finishing: " + Thread.currentThread())
}

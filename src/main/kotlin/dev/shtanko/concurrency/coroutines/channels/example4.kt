package dev.shtanko.concurrency.coroutines.channels

import kotlinx.coroutines.delay

private const val TICK_MILLIS = 100L
private const val BOOM_MILLIS = 500L
private const val TICK_TO_BOOM_DELAY = 50L

fun main() = mainBlocking {
    val tick = ChannelTime.tick(TICK_MILLIS)
    val boom = ChannelTime.after(BOOM_MILLIS)
    whileSelect {

        tick.onReceive {
            println("tick.")
            true // continue loop
        }
        boom.onReceive {
            println("BOOM!")
            false // break loop
        }
        onDefault {
            println("    .")
            delay(TICK_TO_BOOM_DELAY)
            true // continue loop
        }
    }
}

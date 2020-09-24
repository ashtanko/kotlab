package dev.shtanko.concurrency.coroutines.channels

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.selects.whileSelect

suspend fun fibonacci(n: Int, c: SendChannel<Int>) {
    var x = 0
    var y = 1
    for (i in 0 until n) {
        c.send(x)
        val next = x + y
        x = y
        y = next
    }
    c.close()
}

@ExperimentalCoroutinesApi
suspend fun fibonacci(c: SendChannel<Int>, quit: ReceiveChannel<Int>) {
    var x = 0
    var y = 1
    whileSelect {
        c.onSend(x) {
            val next = x + y
            x = y
            y = next
            true // continue while loop
        }
        quit.onReceive {
            println("quit")
            false // break while loop
        }
    }
}

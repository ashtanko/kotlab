package dev.shtanko.concurrency.coroutines.channels

import kotlinx.coroutines.delay
import java.util.Random

// https://talks.golang.org/2012/concurrency.slide#25

private const val BORING_DELAY = 1000

suspend fun boring(msg: String): ReceiveChannel<String> { // returns receive-only channel of strings
    val c = Channel<String>()
    val rnd = Random()
    go {
        var i = 0
        while (true) {
            c.send("$msg $i")
            delay(rnd.nextInt(BORING_DELAY).toLong())
            i++
        }
    }
    return c // return the channel to the caller
}

// https://talks.golang.org/2012/concurrency.slide#26

fun main() = mainBlocking {
    val joe = boring("Joe")
    val ann = boring("Ann")
    for (i in 0..4) {
        println(joe.receive())
        println(ann.receive())
    }
    println("Your're both boring; I'm leaving.")
}

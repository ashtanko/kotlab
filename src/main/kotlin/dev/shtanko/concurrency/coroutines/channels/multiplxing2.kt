package dev.shtanko.concurrency.coroutines.channels

// https://talks.golang.org/2012/concurrency.slide#27

suspend fun fanIn2(input1: ReceiveChannel<String>, input2: ReceiveChannel<String>): ReceiveChannel<String> {
    val c = Channel<String>()
    go {
        while (true) {
            val s = select<String> {
                input1.onReceive { it }
                input2.onReceive { it }
            }
            c.send(s)
        }
    }
    return c // return combo channel
}

fun main() = mainBlocking {
    val c = fanIn2(boring("Joe"), boring("Ann"))
    for (i in 0..9) {
        println(c.receive())
    }
    println("Your're both boring; I'm leaving.")
}

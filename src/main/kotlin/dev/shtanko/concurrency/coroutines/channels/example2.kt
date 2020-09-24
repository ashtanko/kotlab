package dev.shtanko.concurrency.coroutines.channels

import kotlinx.coroutines.channels.SendChannel

suspend fun sum(s: List<Int>, c: SendChannel<Int>) {
    var sum = 0
    for (v in s) {
        sum += v
    }
    c.send(sum)
}

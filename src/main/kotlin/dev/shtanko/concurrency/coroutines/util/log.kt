package dev.shtanko.concurrency.coroutines.util

import java.time.Instant

fun log(msg: String) = println("${Instant.now()} [${Thread.currentThread().name}] $msg")

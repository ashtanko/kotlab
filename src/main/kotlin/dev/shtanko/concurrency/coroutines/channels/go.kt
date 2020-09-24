package dev.shtanko.concurrency.coroutines.channels

import dev.shtanko.concurrency.coroutines.context.CommonPool
import dev.shtanko.concurrency.coroutines.run.runBlocking

fun mainBlocking(block: suspend () -> Unit) = runBlocking(CommonPool, block)

fun go(block: suspend () -> Unit) = CommonPool.runParallel(block)

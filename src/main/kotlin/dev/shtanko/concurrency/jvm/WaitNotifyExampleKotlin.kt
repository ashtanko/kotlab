/*
 * Copyright 2020 Alexey Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.concurrency.jvm

import java.util.Random
import kotlin.concurrent.thread

private const val MAX_ITEMS = 5
private const val SLEEP_MILLIS = 1000L
private const val OBSERVE_COUNT = 14

class WaitNotifyExampleKotlin(private val maxItems: Int) {

    @Volatile
    private var items = 0
    private val rand = Random()

    private val lock = Object()

    fun produce() = synchronized(lock) {
        while (items >= maxItems) {
            lock.wait()
        }
        Thread.sleep(rand.nextInt(BOUND).toLong())
        items++
        println("Produced, count is $items: ${Thread.currentThread()}")
        lock.notifyAll()
    }

    fun consume() = synchronized(lock) {
        while (items <= 0) {
            lock.wait()
        }
        Thread.sleep(rand.nextInt(BOUND).toLong())
        items--
        println("Consumed, count is $items: ${Thread.currentThread()}")
        lock.notifyAll()
    }

    companion object {
        private const val BOUND = 100
    }
}

fun main() {
    println("starting: ${Thread.currentThread()}")

    val example = WaitNotifyExampleKotlin(MAX_ITEMS)

    for (i in 0..OBSERVE_COUNT) {
        thread(start = true) {
            if (i < MAX_ITEMS) {
                example.consume()
            } else {
                example.produce()
            }
        }
    }

    Thread.sleep(SLEEP_MILLIS)
    println("finishing: ${Thread.currentThread()}")
}

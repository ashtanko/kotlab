package dev.shtanko.concurrency.coroutines.channels

import dev.shtanko.concurrency.coroutines.mutex.MyMutex
import kotlinx.coroutines.delay

// https://tour.golang.org/concurrency/9

private const val HUNDRED_COROUTINES = 999
private const val RESULT_DELAY = 1000L

class SafeCounter {
    private val v = mutableMapOf<String, Int>()
    private val mux = MyMutex()

    suspend fun inc(key: String) {
        mux.lock()
        try {
            v[key] = v.getOrDefault(key, 0) + 1
        } finally {
            mux.unlock()
        }
    }

    suspend fun get(key: String): Int? {
        mux.lock()
        return try {
            v[key]
        } finally {
            mux.unlock()
        }
    }
}

fun main() = mainBlocking {
    val c = SafeCounter()
    for (i in 0..HUNDRED_COROUTINES) {
        go { c.inc("somekey") } // 1000 concurrent coroutines
    }
    delay(RESULT_DELAY)
    println("${c.get("somekey")}")
}

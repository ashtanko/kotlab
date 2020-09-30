package dev.shtanko.kotlinlang.collections

import java.util.Collections

fun main() {
    val hashmap = HashMap<Int, String>()

    hashmap[0] = "A"
    hashmap[1] = "B"
    hashmap[2] = "C"

    val map = Collections.synchronizedMap(hashmap)
    val set = map.entries
    synchronized(map) {
        val i = set.iterator()
        while (i.hasNext()) {
            val pair = i.next()
            println("${pair.key} ${pair.value}")
        }
    }
}

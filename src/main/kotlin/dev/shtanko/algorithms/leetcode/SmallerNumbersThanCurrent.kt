package dev.shtanko.algorithms.leetcode

import java.util.Arrays
import java.util.HashMap
import java.util.TreeMap

fun IntArray.smallerNumbersThanCurrentNaive(): IntArray {
    val map: MutableMap<Int, Int> = HashMap()
    val copy = this.clone()
    Arrays.sort(copy)
    for (i in indices) {
        map.putIfAbsent(copy[i], i)
    }
    for (i in indices) {
        copy[i] = map[this[i]]!!
    }
    return copy
}

fun IntArray.smallerNumbersThanCurrent(): IntArray {
    val map: MutableMap<Int, Int> = TreeMap()
    for (num in this) { // O(nlgn)
        map[num] = map.getOrDefault(num, 0) + 1
    }
    var lessNumbers = 0
    for (num in map.keys) { // O(n)
        val tmp = map[num]!!
        map[num] = lessNumbers
        lessNumbers += tmp
    }
    for (i in this.indices) { // O(n)
        this[i] = map[this[i]]!!
    }
    return this
}

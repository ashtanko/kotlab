package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import java.util.TreeMap

fun IntArray.arrayRankTransform(): IntArray {
    val map: MutableMap<Int, MutableList<Int>> =
        TreeMap()
    for (i in indices) {
        val current = map.getOrDefault(this[i], ArrayList())
        current.add(i)
        map[this[i]] = current
    }
    var rank = 1
    for ((_, currentList) in map) {
        for (i in currentList) this[i] = rank
        rank++
    }
    return this
}

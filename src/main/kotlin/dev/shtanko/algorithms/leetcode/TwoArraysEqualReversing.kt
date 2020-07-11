package dev.shtanko.algorithms.leetcode

import java.util.HashMap

fun Pair<IntArray, IntArray>.canBeEqualSort(): Boolean {
    first.sort()
    second.sort()
    return first.contentEquals(second)
}

fun Pair<IntArray, IntArray>.canBeEqual(): Boolean {
    val arr = second
    val target = first
    val n = arr.size
    val map = HashMap<Int, Int?>()
    for (i in 0 until n) {
        if (!map.containsKey(arr[i])) map[arr[i]] = 1 else map[arr[i]] = map[arr[i]]!! + 1
    }
    for (i in 0 until n) {
        if (!map.containsKey(target[i])) return false
        var count = map[target[i]]!!
        count--
        if (count == 0) map.remove(target[i]) else map[target[i]] = count
    }
    return true
}

package dev.shtanko.algorithms.leetcode

fun IntArray.uniqueOccurrences(): Boolean {
    val count: MutableMap<Int, Int> = HashMap()
    for (num in this) {
        count[num] = 1 + count.getOrDefault(num, 0)
    }
    return count.size == count.values.toHashSet().size
}

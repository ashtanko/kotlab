package dev.shtanko.algorithms.leetcode

fun Pair<String, IntArray>.restoreString(): String {
    val c = CharArray(second.size)
    for (i in second.indices) {
        c[second[i]] = first[i]
    }
    return String(c)
}

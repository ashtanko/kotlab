package dev.shtanko.algorithms.leetcode

fun String.diStringMatch(): IntArray {
    val n = this.length
    var left = 0
    var right = n
    val res = IntArray(n + 1)
    for (i in 0 until n) {
        res[i] = if (this[i] == 'I') left++ else right--
    }
    res[n] = left
    return res
}

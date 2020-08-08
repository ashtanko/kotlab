package dev.shtanko.algorithms.leetcode

fun IntArray.isMonotonic(): Boolean {
    val n = size
    if (n == 1) return true
    val up = this[n - 1] - this[0] > 0
    for (i in 0 until n - 1) {
        val local = this[i + 1] - this[i] > 0
        if (this[i + 1] != this[i] && local != up) {
            return false
        }
    }
    return true
}

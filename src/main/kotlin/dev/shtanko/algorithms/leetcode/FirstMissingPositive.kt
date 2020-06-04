package dev.shtanko.algorithms.leetcode

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 */
fun IntArray.firstMissingPositive(): Int {
    val n = this.size
    if (n == 0) return 1
    for (i in 0 until n) {
        var current = this[i]
        while (current - 1 in 0 until n && current != this[current - 1]) {
            val next = this[current - 1]
            this[current - 1] = current
            current = next
        }
    }
    for (i in 0 until n) {
        if (this[i] != i + 1) {
            return i + 1
        }
    }
    return n + 1
}

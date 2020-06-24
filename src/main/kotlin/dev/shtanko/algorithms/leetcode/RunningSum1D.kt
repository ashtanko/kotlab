package dev.shtanko.algorithms.leetcode

fun IntArray.runningSumNaive(): IntArray {
    if (isEmpty() || size <= 1) return intArrayOf()
    for (i in 1 until size) {
        this[i] += this[i - 1]
    }
    return this
}

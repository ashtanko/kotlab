package dev.shtanko.algorithms.leetcode

import kotlin.math.abs

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number,
 * also in sorted non-decreasing order.
 */
fun IntArray.sortedSquares(): IntArray {
    val n = size

    val result = IntArray(n)

    var i = 0
    var j = n - 1

    for (p in n - 1 downTo 0) {
        if (abs(this[i]) > abs(this[j])) {
            result[p] = this[i] * this[i]
            i++
        } else {
            result[p] = this[j] * this[j]
            j--
        }
    }

    return result
}

fun IntArray.sortedSquares2(): IntArray {

    for (i in indices) {
        this[i] = this[i] * this[i]
    }

    sort()

    return this
}

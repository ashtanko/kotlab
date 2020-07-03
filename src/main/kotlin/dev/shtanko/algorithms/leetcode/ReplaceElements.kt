package dev.shtanko.algorithms.leetcode

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right,
 * and replace the last element with -1.
 */
fun IntArray.replaceElements(): IntArray {
    var mx = -1
    val n = size
    var a: Int

    for (i in n - 1 downTo 0) {
        a = this[i]
        this[i] = mx
        mx = mx.coerceAtLeast(a)
    }

    return this
}

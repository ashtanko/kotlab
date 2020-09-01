package dev.shtanko.algorithms.leetcode

import java.util.Arrays

private fun IntArray.check(leftSum: Int, leftNum: Int, startIndex: Int): Boolean {
    if (leftNum == 0) return leftSum == 0
    if (this[startIndex] > leftSum / leftNum) return false
    for (i in startIndex until this.size - leftNum + 1) {
        if (i > startIndex && this[i] == this[i - 1]) continue
        if (this.check(leftSum - this[i], leftNum - 1, i + 1)) return true
    }
    return false
}

fun IntArray.splitArraySameAverage(): Boolean {
    if (this.size == 1) return false
    var sumA = 0
    for (a in this) sumA += a
    Arrays.sort(this)
    for (lenOfB in 1..this.size / 2) {
        if (sumA * lenOfB % this.size == 0) {
            if (this.check(sumA * lenOfB / this.size, lenOfB, 0)) return true
        }
    }
    return false
}

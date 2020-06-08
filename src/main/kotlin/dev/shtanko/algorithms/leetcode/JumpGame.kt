package dev.shtanko.algorithms.leetcode

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 */
fun IntArray.canJump(): Boolean {
    if (this.isEmpty()) return false

    var max = 0
    for (i in this.indices) {

        if (i > max) {
            return false
        }
        max = (this[i] + i).coerceAtLeast(max)
    }

    return true
}

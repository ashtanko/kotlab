package dev.shtanko.algorithms.leetcode

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once
 * and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place
 * with O(1) extra memory.
 */
fun IntArray.removeDuplicates(): Int {
    val n = this.size
    if (n < 2) return n
    var count = 0
    for (i in 1 until n) {
        if (this[i] == this[i - 1]) count++
        else this[i - count] = this[i]
    }
    return n - count
}

package dev.shtanko.algorithms.leetcode

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative
 * order of the non-zero elements.
 */
fun IntArray.moveZeroes() {
    var pos = 0
    for (i in indices) {
        if (this[i] != 0) {
            if (i != pos) {
                this[pos] = this[i]
                this[i] = 0
            }
            pos++
        }
    }
}

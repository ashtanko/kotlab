package dev.shtanko.algorithms.leetcode

/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 */
fun IntArray.findNumbers(): Int {
    var count = 0
    for (num in this) {
        if (num.toString().length % 2 == 0) {
            count++
        }
    }
    return count
}

package dev.shtanko.algorithms.leetcode

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place
 * with O(1) extra memory.
 */
fun CharArray.reverse() {
    var start = 0
    var end = size - 1

    while (start < end) {
        val tmp = this[start]
        this[start] = this[end]
        this[end] = tmp
        start++
        end--
    }
}

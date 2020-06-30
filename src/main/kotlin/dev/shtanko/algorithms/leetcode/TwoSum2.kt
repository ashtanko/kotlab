package dev.shtanko.algorithms.leetcode

fun IntArray.twoSum2(target: Int): IntArray {
    var start = 0
    var end = size - 1
    while (start < end) {
        if (this[start] + this[end] == target) {
            break
        }
        if (this[start] + this[end] < target) {
            start++
        } else {
            end--
        }
    }
    return intArrayOf(start + 1, end + 1)
}

package dev.shtanko.algorithms.leetcode

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 */
fun IntArray.jump(): Int {
    var jumps = 0
    var curEnd = 0
    var curFarthest = 0

    for (i in 0 until size - 1) {
        curFarthest = kotlin.math.max(curFarthest, i + this[i])
        if (i == curEnd) {
            jumps++
            curEnd = curFarthest
        }
    }

    return jumps
}

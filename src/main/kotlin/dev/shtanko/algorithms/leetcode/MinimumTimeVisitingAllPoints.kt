package dev.shtanko.algorithms.leetcode

import kotlin.math.abs

fun Array<IntArray>.minTimeToVisitAllPoints(): Int {
    var ans = 0
    for (i in 1 until size) {
        val prev = this[i - 1]
        val cur = this[i]
        ans += abs(cur[0] - prev[0]).coerceAtLeast(abs(cur[1] - prev[1]))
    }
    return ans
}

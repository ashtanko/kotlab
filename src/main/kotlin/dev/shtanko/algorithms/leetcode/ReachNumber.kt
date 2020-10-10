package dev.shtanko.algorithms.leetcode

import kotlin.math.abs

fun reachNumber(target: Int): Int {
    val t = abs(target)
    var step = 0
    var sum = 0
    while (sum < t) {
        step++
        sum += step
    }
    while ((sum - t) % 2 != 0) {
        step++
        sum += step
    }
    return step
}

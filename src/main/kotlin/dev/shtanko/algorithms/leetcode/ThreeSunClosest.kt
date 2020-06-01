package dev.shtanko.algorithms.leetcode

import kotlin.math.abs

fun IntArray.threeSumClosest(target: Int): Int {
    var result = this[0] + this[1] + this[this.size - 1]
    sort()
    for (i in 0 until this.size - 2) {
        var start = i + 1
        var end = this.size - 1
        while (start < end) {
            val sum = this[i] + this[start] + this[end]
            if (sum > target) {
                end--
            } else {
                start++
            }
            if (abs(sum - target) < abs(result - target)) {
                result = sum
            }
        }
    }

    return result
}

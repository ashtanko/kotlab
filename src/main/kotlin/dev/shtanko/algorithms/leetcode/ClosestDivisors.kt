package dev.shtanko.algorithms.leetcode

import kotlin.math.sqrt

fun closestDivisors(num: Int): IntArray {
    for (a in sqrt(num.plus(2).toDouble()).toInt() downTo 1) {
        if ((num + 1) % a == 0) return intArrayOf(a, num.plus(1) / a)
        if ((num + 2) % a == 0) return intArrayOf(a, num.plus(2) / a)
    }
    return intArrayOf()
}

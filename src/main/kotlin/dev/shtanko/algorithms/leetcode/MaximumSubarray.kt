package dev.shtanko.algorithms.leetcode

fun IntArray.maxSubArray(): Int {

    var res = Int.MIN_VALUE
    var sum = 0

    for (i in this.indices) {
        sum = sum.coerceAtLeast(0) + this[i]
        res = res.coerceAtLeast(sum)
    }

    return res
}

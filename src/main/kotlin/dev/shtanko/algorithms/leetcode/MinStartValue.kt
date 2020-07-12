package dev.shtanko.algorithms.leetcode

fun IntArray.findMinStartValue(): Int {
    var sum = 0
    var minSum = 0
    for (num in this) {
        sum += num
        minSum = minSum.coerceAtMost(sum)
    }
    return if (minSum == 0) {
        1
    } else {
        -minSum + 1
    }
}

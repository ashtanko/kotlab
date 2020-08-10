package dev.shtanko.algorithms.leetcode

fun IntArray.maxProfit(): Int {
    var profit = 0
    if (this.isEmpty()) return profit
    for (i in 1 until size) {
        profit += 0.coerceAtLeast(this[i] - this[i - 1])
    }
    return profit
}

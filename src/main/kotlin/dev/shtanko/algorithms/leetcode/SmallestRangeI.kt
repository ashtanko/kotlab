package dev.shtanko.algorithms.leetcode

fun Pair<IntArray, Int>.smallestRangeI(): Int {
    var min = this.first[0]
    var max = this.first[0]
    for (x in first) {
        min = min.coerceAtMost(x)
        max = max.coerceAtLeast(x)
    }
    return 0.coerceAtLeast(max - min - 2 * second)
}

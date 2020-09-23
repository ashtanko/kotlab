package dev.shtanko.algorithms.leetcode

fun maxScoreSightseeingPair(arr: IntArray): Int {
    var res = 0
    var cur = 0
    for (a in arr) {
        res = res.coerceAtLeast(cur + a)
        cur = cur.coerceAtLeast(a) - 1
    }
    return res
}

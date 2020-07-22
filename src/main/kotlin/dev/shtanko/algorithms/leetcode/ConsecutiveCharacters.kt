package dev.shtanko.algorithms.leetcode

fun String.maxPower(): Int {
    val n = length
    var start = 0
    var end = 0
    var max = 0
    while (end < n) {
        while (end < n && this[end] == this[start]) {
            max = max.coerceAtLeast(end - start + 1)
            end++
        }
        if (end == n) return max
        start = end
    }
    return max
}

fun String.maxPower2(): Int {
    var res = 0
    val n = this.length
    var i = 0
    while (i < n) {
        val j = i
        while (i + 1 < n && this[i] == this[i + 1]) {
            i++
        }
        res = kotlin.math.max(i - j + 1, res)
        i++
    }
    return res
}

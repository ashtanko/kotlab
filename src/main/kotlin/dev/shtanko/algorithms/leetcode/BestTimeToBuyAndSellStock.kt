package dev.shtanko.algorithms.leetcode

fun IntArray.maxProfitSimple(): Int {
    var maxCur = 0
    var maxSoFar = 0
    for (i in 1 until size) {
        maxCur += this[i] - this[i - 1]
        maxCur = 0.coerceAtLeast(maxCur)
        maxSoFar = maxCur.coerceAtLeast(maxSoFar)
    }
    return maxSoFar
}

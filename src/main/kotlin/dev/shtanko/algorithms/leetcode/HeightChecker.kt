package dev.shtanko.algorithms.leetcode

private const val ARR_MAX_SIZE = 101

fun IntArray.heightChecker(): Int {
    val heightToFreq = IntArray(ARR_MAX_SIZE)
    for (height in this) {
        heightToFreq[height]++
    }
    var result = 0
    var curHeight = 0
    for (i in indices) {
        while (heightToFreq[curHeight] == 0) {
            curHeight++
        }
        if (curHeight != this[i]) {
            result++
        }
        heightToFreq[curHeight]--
    }
    return result
}

fun IntArray.heightCheckerSort(): Int {
    var count = 0
    val copy = this.clone()
    copy.sort()
    for (i in copy.indices) {
        if (this[i] != copy[i]) {
            count++
        }
    }
    return count
}

package dev.shtanko.algorithms.leetcode

private const val MAX_SUB_ARRAY_SIZE = 2

fun IntArray.numTeams(): Int {
    var res = 0
    for (i in 1 until size - 1) {
        val less = IntArray(MAX_SUB_ARRAY_SIZE)
        val greater = IntArray(MAX_SUB_ARRAY_SIZE)
        for (j in 0 until size) {
            if (this[i] < this[j]) {
                ++less[if (j > i) 1 else 0]
            }
            if (this[i] > this[j]) {
                ++greater[if (j > i) 1 else 0]
            }
        }
        res += less[0] * greater[1] + greater[0] * less[1]
    }
    return res
}

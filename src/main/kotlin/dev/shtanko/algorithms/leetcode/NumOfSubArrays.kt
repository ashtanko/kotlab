package dev.shtanko.algorithms.leetcode

private const val E_9 = 1e9
private const val MODULE = 7

fun numOfSubArrays(arr: IntArray): Int {
    var cur = 0
    var res = 0
    val count = intArrayOf(1, 0)
    val mod = E_9.toInt() + MODULE
    for (a in arr) {
        cur = cur xor (a and 1)
        res = (res + count[1 - cur]) % mod
        count[cur]++
    }
    return res
}

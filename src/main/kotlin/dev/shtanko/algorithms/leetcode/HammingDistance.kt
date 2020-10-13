package dev.shtanko.algorithms.leetcode

fun hammingDistance(x: Int, y: Int): Int {
    var xor = x xor y
    var res = 0
    while (xor != 0) {
        res += xor and 1
        xor = xor shr 1
    }
    return res
}

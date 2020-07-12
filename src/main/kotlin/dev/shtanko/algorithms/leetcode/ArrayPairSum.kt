package dev.shtanko.algorithms.leetcode

fun IntArray.pairSum(): Int {
    sort()
    val list = toList()
    val chunks = list.chunked(2)
    var res = 0
    for (chunk in chunks) {
        res += kotlin.math.min(chunk.first(), chunk.last())
    }
    return res
}

fun IntArray.pairSum2(): Int {
    sort()
    var res = 0
    var i = 0
    while (i < size) {
        res += this[i]
        i += 2
    }
    return res
}

private const val MAX_ARR_SIZE = 20001
private const val ARR_HELPER = 10000

fun IntArray.pairSum3(): Int {
    val exist = IntArray(MAX_ARR_SIZE)
    for (i in indices) {
        exist[this[i] + ARR_HELPER]++
    }
    var sum = 0
    var isOdd = true
    for (i in exist.indices) {
        while (exist[i] > 0) {
            if (isOdd) {
                sum += i - ARR_HELPER
            }
            isOdd = !isOdd
            exist[i]--
        }
    }
    return sum
}

fun IntArray.pairSum4(): Int {
    sort()
    return toList().chunked(2) { it.min() ?: 0 }.sum()
}

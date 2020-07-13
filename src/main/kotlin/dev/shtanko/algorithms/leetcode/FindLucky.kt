package dev.shtanko.algorithms.leetcode

private const val MAX_ARR_SIZE = 500

fun IntArray.findLucky(): Int {
    val cnt = IntArray(MAX_ARR_SIZE + 1)
    for (a in this) {
        ++cnt[a]
    }
    for (i in MAX_ARR_SIZE downTo 1) {
        if (cnt[i] == i) {
            return i
        }
    }
    return -1
}

fun IntArray.findLuckyMap(): Int {
    val freq: MutableMap<Int, Int> = HashMap()
    for (a in this) {
        freq[a] = 1 + freq.getOrDefault(a, 0) // Accumulate the occurrence of a.
    }
    var ans = -1
    for ((key, value) in freq) {
        if (key == value) {
            ans = ans.coerceAtLeast(key)
        }
    }
    return ans
}

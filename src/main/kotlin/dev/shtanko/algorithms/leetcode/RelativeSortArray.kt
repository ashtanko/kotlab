package dev.shtanko.algorithms.leetcode

import java.util.*

private const val MAX_ARRAY_SIZE = 1001

fun Pair<IntArray, IntArray>.relativeSortArray(): IntArray {
    val cnt = IntArray(MAX_ARRAY_SIZE)
    for (n in first) {
        cnt[n]++
    }
    var i = 0
    for (n in second) {
        while (cnt[n]-- > 0) {
            first[i++] = n
        }
    }
    for (n in cnt.indices) {
        while (cnt[n]-- > 0) {
            first[i++] = n
        }
    }
    return first
}

fun Pair<IntArray, IntArray>.relativeSortArrayTree(): IntArray {
    val tree = TreeMap<Int, Int>()
    for (n in first) {
        tree[n] = tree.getOrDefault(n, 0) + 1
    }
    var i = 0
    for (n in second) {
        for (j in 0 until tree[n]!!) {
            first[i++] = n
        }
        tree.remove(n)
    }
    for (n in tree.keys) {
        for (j in 0 until tree[n]!!) {
            first[i++] = n
        }
    }
    return first
}

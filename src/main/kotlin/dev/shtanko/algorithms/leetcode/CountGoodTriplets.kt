package dev.shtanko.algorithms.leetcode

import kotlin.math.abs

fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    var count = 0
    val n = arr.size
    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            if (abs(arr[i] - arr[j]) <= a) {
                for (k in j + 1 until n) {
                    if (abs(arr[j] - arr[k]) <= b && abs(arr[k] - arr[i]) <= c) {
                        count++
                    }
                }
            }
        }
    }
    return count
}

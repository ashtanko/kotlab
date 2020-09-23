package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.extensions.second

fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
    val res = IntArray(n)
    for (b in bookings) {
        res[b.first() - 1] += b[2]
        if (b.second() < n) res[b[1]] -= b[2]
    }
    for (i in 1 until n) res[i] += res[i - 1]
    return res
}

package dev.shtanko.algorithms.leetcode

fun sumEvenAfterQueries(a: IntArray, queries: Array<IntArray>): IntArray {
    var s = 0
    for (x in a) if (x % 2 == 0) s += x

    val ans = IntArray(queries.size)

    for (i in queries.indices) {
        val value = queries[i][0]
        val index = queries[i][1]
        if (a[index] % 2 == 0) s -= a[index]
        a[index] += value
        if (a[index] % 2 == 0) s += a[index]
        ans[i] = s
    }

    return ans
}

package dev.shtanko.algorithms.leetcode

/**
 * Two City Scheduling
 */
fun Array<IntArray>.twoCitySchedCost(): Int {
    var cost = 0

    sortWith(Comparator { a: IntArray, b: IntArray ->
        val first = a[1] - a[0]
        val second = b[1] - b[0]
        first - second
    })

    for (i in 0 until size / 2) {
        cost += this[i][1] + this[size - i - 1][0]
    }

    return cost
}

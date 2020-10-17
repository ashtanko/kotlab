package dev.shtanko.algorithms.leetcode

import java.util.TreeSet

fun maxSumSubMatrix(matrix: Array<IntArray>, target: Int): Int {
    val row: Int = matrix.size
    if (row == 0) return 0
    val col: Int = matrix[0].size
    val m = row.coerceAtMost(col)
    val n = row.coerceAtLeast(col)
    val colIsBig = col > row
    var res = Int.MIN_VALUE
    for (i in 0 until m) {
        val array = IntArray(n)
        for (j in i downTo 0) {
            var value = 0
            val set: TreeSet<Int> = TreeSet()
            set.add(0)
            for (k in 0 until n) {
                array[k] = array[k] + if (colIsBig) matrix[j][k] else matrix[k][j]
                value += array[k]
                val subRes: Int? = set.ceiling(value - target)
                if (null != subRes) {
                    res = res.coerceAtLeast(value - subRes)
                }
                set.add(value)
            }
        }
    }
    return res
}

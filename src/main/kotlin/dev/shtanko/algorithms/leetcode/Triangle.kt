package dev.shtanko.algorithms.leetcode

fun minimumTotal(triangle: List<List<Int>>): Int {
    val a = IntArray(triangle.size + 1)
    for (i in triangle.size - 1 downTo 0) {
        for (j in triangle[i].indices) {
            a[j] = a[j].coerceAtMost(a[j + 1]) + triangle[i][j]
        }
    }
    return a[0]
}

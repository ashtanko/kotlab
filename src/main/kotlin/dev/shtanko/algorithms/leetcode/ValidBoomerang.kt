package dev.shtanko.algorithms.leetcode

fun isBoomerang(points: Array<IntArray>): Boolean {
    val f = points[0][0].minus(points[1][0]) * points[0][1].minus(points[2][1])
    val s = points[0][0].minus(points[2][0]) * points[0][1].minus(points[1][1])
    return f != s
}

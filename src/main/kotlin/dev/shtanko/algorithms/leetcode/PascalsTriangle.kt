package dev.shtanko.algorithms.leetcode

fun Int.pascalsTriangle(): List<List<Int>> {
    val triangle: MutableList<MutableList<Int>> = ArrayList()
    if (this <= 0) {
        return triangle
    }
    for (i in 0 until this) {
        val row: MutableList<Int> = ArrayList()
        for (j in 0 until i + 1) {
            if (j == 0 || j == i) {
                row.add(1)
            } else {
                row.add(triangle[i - 1][j - 1] + triangle[i - 1][j])
            }
        }
        triangle.add(row)
    }
    return triangle
}

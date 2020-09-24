package dev.shtanko.algorithms.leetcode

fun minPathSum(grid: Array<IntArray>): Int {
    val m: Int = grid.size
    val n: Int = grid.first().size
    for (i in 1 until n) {
        grid.first()[i] += grid.first()[i - 1]
    }
    for (i in 1 until m) {
        grid[i][0] += grid[i - 1].first()
        for (j in 1 until n) {
            grid[i][j] += grid[i][j - 1].coerceAtMost(grid[i - 1][j])
        }
    }
    return grid[m - 1][n - 1]
}

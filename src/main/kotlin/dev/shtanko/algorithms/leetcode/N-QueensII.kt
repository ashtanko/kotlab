package dev.shtanko.algorithms.leetcode

private val occupiedCols = hashSetOf<Int>()
private val occupiedDiag1s = hashSetOf<Int>()
private val occupiedDiag2s = hashSetOf<Int>()

fun Int.totalNQueens(): Int {
    return this.totalNQueensHelper(0, 0)
}

private fun Int.totalNQueensHelper(row: Int, c: Int): Int {
    var count = c
    for (col in 0 until this) {
        if (occupiedCols.contains(col)) {
            continue
        }
        val diag1 = row - col
        if (occupiedDiag1s.contains(diag1)) {
            continue
        }
        val diag2 = row + col
        if (occupiedDiag2s.contains(diag2)) {
            continue
        }
        // we can now place a queen here
        if (row == this - 1) count++ else {
            occupiedCols.add(col)
            occupiedDiag1s.add(diag1)
            occupiedDiag2s.add(diag2)
            count = this.totalNQueensHelper(row + 1, count)
            // recover
            occupiedCols.remove(col)
            occupiedDiag1s.remove(diag1)
            occupiedDiag2s.remove(diag2)
        }
    }

    return count
}

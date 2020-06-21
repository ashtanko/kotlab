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

private var count = 0

fun Int.totalNQueens2(): Int {
    val cols = BooleanArray(this)
    val d1 = BooleanArray(2 * this)
    val d2 = BooleanArray(2 * this)
    this.backtracking(0, cols, d1, d2)
    return count
}

private fun Int.backtracking(row: Int, cols: BooleanArray, d1: BooleanArray, d2: BooleanArray) {
    if (row == this) count++
    for (col in 0 until this) {
        val id1 = col - row + this
        val id2 = col + row
        if (cols[col] || d1[id1] || d2[id2]) {
            continue
        }
        cols[col] = true
        d1[id1] = true
        d2[id2] = true
        this.backtracking(row + 1, cols, d1, d2)
        cols[col] = false
        d1[id1] = false
        d2[id2] = false
    }
}

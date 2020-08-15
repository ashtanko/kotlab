package dev.shtanko.algorithms.leetcode

fun Pair<Array<IntArray>, Int>.kWeakestRows(): IntArray {
    val matrix = first
    val rows = matrix.size
    val cols = matrix.first().size
    val score = IntArray(rows)
    var j: Int
    for (i in 0 until rows) {
        j = 0
        while (j < cols) {
            if (matrix[i][j] == 0) {
                break
            }
            j++
        }
        score[i] = j * rows + i
    }
    score.sort()
    for (i in score.indices) {
        score[i] = score[i] % rows
    }
    return score.copyOfRange(0, second)
}

package dev.shtanko.algorithms.leetcode

private const val FOUR = 4 // todo rename
private const val TWO = 2 // todo rename

fun Array<IntArray>.islandPerimeter(): Int {
    var islands = 0
    var neighbours = 0
    for (i in indices) {
        for (j in this[i].indices) {
            if (this[i][j] == 1) {
                islands++
                // count down neighbours
                if (i < this.size - 1 && this[i + 1][j] == 1) {
                    neighbours++
                }
                // count right neighbours
                if (j < this[i].size - 1 && this[i][j + 1] == 1) {
                    neighbours++
                }
            }
        }
    }
    return islands * FOUR - neighbours * TWO
}

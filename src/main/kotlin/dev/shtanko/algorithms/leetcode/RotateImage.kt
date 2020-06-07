package dev.shtanko.algorithms.leetcode

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 */
fun Array<IntArray>.rotateImage() {

    for (i in this.indices) {
        for (j in i until this[0].size) {
            val tmp = this[i][j]
            this[i][j] = this[j][i]
            this[j][i] = tmp
        }
    }

    for (i in this.indices) {
        for (j in 0 until this.size / 2) {
            val tmp = this[i][j]
            this[i][j] = this[i][this.size - 1 - j]
            this[i][this.size - 1 - j] = tmp
        }
    }
}

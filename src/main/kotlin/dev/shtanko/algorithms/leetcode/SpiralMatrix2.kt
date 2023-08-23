/*
 * Copyright 2023 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

/**
 * 59. Spiral Matrix II
 * @see <a href="https://leetcode.com/problems/spiral-matrix-ii/description/">leetcode page</a>
 */
interface SpiralMatrix2 {
    fun generateMatrix(n: Int): Array<IntArray>
}

/**
 * Approach 1: Traverse Layer by Layer in Spiral Form
 */
class SpiralMatrix2Traverse : SpiralMatrix2 {
    override fun generateMatrix(n: Int): Array<IntArray> {
        val result = Array(n) { IntArray(n) }
        var cnt = 1
        for (layer in 0 until (n + 1) / 2) {
            // direction 1 - traverse from left to right
            for (ptr in layer until n - layer) {
                result[layer][ptr] = cnt++
            }
            // direction 2 - traverse from top to bottom
            for (ptr in layer + 1 until n - layer) {
                result[ptr][n - layer - 1] = cnt++
            }
            // direction 3 - traverse from right to left
            for (ptr in layer + 1 until n - layer) {
                result[n - layer - 1][n - ptr - 1] = cnt++
            }
            // direction 4 - traverse from bottom to top
            for (ptr in layer + 1 until n - layer - 1) {
                result[n - ptr - 1][layer] = cnt++
            }
        }
        return result
    }
}

class SpiralMatrix2Optimized : SpiralMatrix2 {
    override fun generateMatrix(n: Int): Array<IntArray> {
        val result = Array(n) { IntArray(n) }
        var cnt = 1
        val dir = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
        )
        var d = 0
        var row = 0
        var col = 0
        while (cnt <= n * n) {
            result[row][col] = cnt++
            val r = Math.floorMod(row + dir[d][0], n)
            val c = Math.floorMod(col + dir[d][1], n)

            // change direction if next cell is non-zero
            if (result[r][c] != 0) d = (d + 1) % 4
            row += dir[d][0]
            col += dir[d][1]
        }
        return result
    }
}

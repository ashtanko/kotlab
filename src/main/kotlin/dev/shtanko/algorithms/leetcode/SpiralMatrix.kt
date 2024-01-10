/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
fun interface SpiralOrder {
    operator fun invoke(matrix: Array<IntArray>): List<Int>
}

class SpiralOrderSolution : SpiralOrder {
    override fun invoke(matrix: Array<IntArray>): List<Int> {
        val res: MutableList<Int> = ArrayList()
        if (matrix.isEmpty()) {
            return res
        }

        var rowBegin = 0
        var rowEnd = matrix.size - 1
        var colBegin = 0
        var colEnd: Int = matrix[0].size - 1

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            traverseRight(matrix, rowBegin, colBegin, colEnd, res)
            rowBegin++

            traverseDown(matrix, colEnd, rowBegin, rowEnd, res)
            colEnd--

            if (rowBegin <= rowEnd) {
                traverseLeft(matrix, rowEnd, colBegin, colEnd, res)
            }
            rowEnd--

            if (colBegin <= colEnd) {
                traverseUp(matrix, colBegin, rowBegin, rowEnd, res)
            }
            colBegin++
        }

        return res
    }

    private fun traverseRight(matrix: Array<IntArray>, row: Int, startCol: Int, endCol: Int, res: MutableList<Int>) {
        for (j in startCol..endCol) {
            res.add(matrix[row][j])
        }
    }

    private fun traverseDown(matrix: Array<IntArray>, col: Int, startRow: Int, endRow: Int, res: MutableList<Int>) {
        for (j in startRow..endRow) {
            res.add(matrix[j][col])
        }
    }

    private fun traverseLeft(matrix: Array<IntArray>, row: Int, startCol: Int, endCol: Int, res: MutableList<Int>) {
        for (j in endCol downTo startCol) {
            res.add(matrix[row][j])
        }
    }

    private fun traverseUp(matrix: Array<IntArray>, col: Int, startRow: Int, endRow: Int, res: MutableList<Int>) {
        for (j in endRow downTo startRow) {
            res.add(matrix[j][col])
        }
    }
}

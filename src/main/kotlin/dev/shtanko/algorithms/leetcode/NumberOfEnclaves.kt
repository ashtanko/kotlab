/*
 * Copyright 2022 Oleksii Shtanko
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

import java.util.LinkedList
import java.util.Queue

/**
 * 1020. Number of Enclaves
 * @link https://leetcode.com/problems/number-of-enclaves/
 */
fun interface NumberOfEnclaves {
    fun invoke(grid: Array<IntArray>): Int
}

class NumberOfEnclavesDFS : NumberOfEnclaves {
    override fun invoke(grid: Array<IntArray>): Int {
        var result = 0
        for (i in grid.indices) {
            for (j in 0 until grid[i].size) {
                if (i == 0 || j == 0 || i == grid.size - 1 || j == grid[i].size - 1) {
                    dfs(grid, i, j)
                }
            }
        }

        for (i in grid.indices) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == 1) result++
            }
        }

        return result
    }

    private fun dfs(a: Array<IntArray>, i: Int, j: Int) {
        if (i >= 0 && i <= a.size - 1 && j >= 0 && j <= a[i].size - 1 && a[i][j] == 1) {
            a[i][j] = 0
            dfs(a, i + 1, j)
            dfs(a, i - 1, j)
            dfs(a, i, j + 1)
            dfs(a, i, j - 1)
        }
    }
}

class NumberOfEnclavesBFS : NumberOfEnclaves {

    private val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    override fun invoke(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0
        if (grid.first().isEmpty()) return 0
        val rows = grid.size
        val cols = grid[0].size
        val visited = Array(rows) { BooleanArray(cols) }
        val q = getStartPositions(grid, visited, rows, cols)
        while (q.size > 0) {
            val cell = q.poll()
            for (i in directions.indices) {
                val row = cell[0] + directions[i][0]
                val col = cell[1] + directions[i][1]
                if (isValid(grid, visited, row, col, rows, cols)) {
                    visited[row][col] = true
                    q.offer(intArrayOf(row, col))
                }
            }
        }
        var unvisitedCount = 0
        for (i in 1 until rows - 1) {
            for (j in 1 until cols - 1) {
                if (grid[i][j] == 1 && !visited[i][j]) unvisitedCount++
            }
        }
        return unvisitedCount
    }

    private fun getStartPositions(
        grid: Array<IntArray>,
        visited: Array<BooleanArray>,
        rows: Int,
        cols: Int,
    ): Queue<IntArray> {
        var top = 0
        val left = 0
        var bottom = rows - 1
        var right = cols - 1
        val q: Queue<IntArray> = LinkedList()

        // UP
        if (top <= bottom && left <= right) {
            for (col in left..right) {
                if (grid[top][col] == 1) {
                    visited[top][col] = true
                    q.offer(intArrayOf(top, col))
                }
            }
            top++
        }

        // RIGHT
        if (top <= bottom && left <= right) {
            for (row in top..bottom) {
                if (grid[row][right] == 1) {
                    visited[row][right] = true
                    q.offer(intArrayOf(row, right))
                }
            }
            right--
        }

        // DOWN
        if (top <= bottom && left <= right) {
            for (col in right downTo left) {
                if (grid[bottom][col] == 1) {
                    visited[bottom][col] = true
                    q.offer(intArrayOf(bottom, col))
                }
            }
            bottom--
        }

        // LEFT
        if (top <= bottom && left <= right) {
            for (row in bottom downTo top) {
                if (grid[row][left] == 1) {
                    visited[row][left] = true
                    q.offer(intArrayOf(row, left))
                }
            }
        }
        return q
    }

    private fun isValid(
        grid: Array<IntArray>,
        visited: Array<BooleanArray>,
        row: Int,
        col: Int,
        rows: Int,
        cols: Int,
    ): Boolean {
        if (!validCoords(row, col, rows, cols)) return false
        return if (visited[row][col]) false else grid[row][col] == 1
    }

    private fun validCoords(row: Int, col: Int, rows: Int, cols: Int): Boolean {
        return row in 0 until rows && col >= 0 && col < cols
    }
}

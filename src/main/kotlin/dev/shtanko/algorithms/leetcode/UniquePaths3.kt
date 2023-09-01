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

/**
 * 980. Unique Paths III
 * @see <a href="https://leetcode.com/problems/unique-paths-iii/">leetcode page</a>
 */
interface UniquePaths3 {
    operator fun invoke(grid: Array<IntArray>): Int
}

class UniquePaths3Backtracking : UniquePaths3 {
    private var res = 0
    private var empty: Int = 1
    private var sx: Int = 0
    private var sy: Int = 0
    override operator fun invoke(grid: Array<IntArray>): Int {
        val m: Int = grid.size
        val n: Int = grid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0) {
                    empty++
                } else if (grid[i][j] == 1) {
                    sx = i
                    sy = j
                }
            }
        }
        dfs(grid, sx, sy)
        return res
    }

    fun dfs(grid: Array<IntArray>, x: Int, y: Int) {
        if (x < 0 || x >= grid.size || y < 0 || y >= grid[0].size || grid[x][y] < 0) return
        if (grid[x][y] == 2) {
            if (empty == 0) res++
            return
        }
        grid[x][y] = -2
        empty--
        dfs(grid, x + 1, y)
        dfs(grid, x - 1, y)
        dfs(grid, x, y + 1)
        dfs(grid, x, y - 1)
        grid[x][y] = 0
        empty++
    }
}

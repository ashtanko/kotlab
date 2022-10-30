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
 * 934. Shortest Bridge
 * @link https://leetcode.com/problems/shortest-bridge/
 */
interface ShortestBridge {
    fun invoke(grid: Array<IntArray>): Int
}

class ShortestBridgeDP : ShortestBridge {
    override fun invoke(grid: Array<IntArray>): Int {
        val queue: Queue<IntArray> = LinkedList()
        var flag = false
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    dfs(i, j, queue, grid)
                    flag = true
                    break
                }
            }
            if (flag) break
        }
        var step = 0
        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        while (!queue.isEmpty()) {
            val size: Int = queue.size
            for (i in 0 until size) {
                val point: IntArray = queue.poll()
                for (dir in dirs) {
                    val x = dir[0] + point[0]
                    val y = dir[1] + point[1]
                    if (x >= 0 && y >= 0 && x < grid.size && y < grid[0].size && grid[x][y] != -1) {
                        if (grid[x][y] == 1) return step
                        queue.offer(intArrayOf(x, y))
                        grid[x][y] = -1
                    }
                }
            }
            step++
        }
        return -1
    }

    private fun dfs(x: Int, y: Int, queue: Queue<IntArray>, arr: Array<IntArray>) {
        if (x < 0 || y < 0 || x == arr.size || y == arr[0].size || arr[x][y] != 1) {
            return
        }
        queue.offer(intArrayOf(x, y))
        arr[x][y] = -1
        dfs(x + 1, y, queue, arr)
        dfs(x - 1, y, queue, arr)
        dfs(x, y + 1, queue, arr)
        dfs(x, y - 1, queue, arr)
    }
}

class ShortestBridgeDFS : ShortestBridge {
    override fun invoke(grid: Array<IntArray>): Int {
        // Use DFS to rename one of the island to "2" so we can distinguish between the two islands
        dfs@ for (row in grid.indices) {
            for (col in 0 until grid[row].size) {
                if (grid[row][col] == 1) {
                    renameIsland(grid, row, col)
                    break@dfs
                }
            }
        }

        // Insert all the 1s to the queue and use BFS to find the shortest path
        val q = ArrayDeque<Pair<Int, Int>>()
        grid.forEachIndexed { row, arr ->
            arr.forEachIndexed { col, value ->
                if (value == 1) {
                    q.add(Pair(row, col))
                }
            }
        }
        return minDist(grid, q)
    }

    // Use DFS to rename one of the island
    private fun renameIsland(a: Array<IntArray>, row: Int, col: Int) {
        if (row >= a.size || row < 0 || col < 0 || col >= a[row].size) return

        if (a[row][col] == 1) {
            a[row][col] = 2
            renameIsland(a, row + 1, col)
            renameIsland(a, row - 1, col)
            renameIsland(a, row, col + 1)
            renameIsland(a, row, col - 1)
        }
    }

    // Use BFS to find minimum path
    private fun minDist(a: Array<IntArray>, q: ArrayDeque<Pair<Int, Int>>): Int {
        var depth = 0
        while (q.size > 0) {
            val depthLevelNodes = q.size
            for (i in 0 until depthLevelNodes) {
                val node = q.first()
                for (pair in node.validNeighbours(a)) {
                    // pair.first is the row and pair.second is the col
                    if (a[pair.first][pair.second] == 2) return depth
                    a[pair.first][pair.second] = 1
                    q.add(pair)
                }
            }
            depth++
        }
        return Int.MAX_VALUE
    }

    // Extension function to get all the 0 and 2 valued neighbours of a particular (row, col)
    private fun Pair<Int, Int>.validNeighbours(a: Array<IntArray>): List<Pair<Int, Int>> {
        val list = mutableListOf<Pair<Int, Int>>()
        val row = this.first
        val col = this.second
        if (row - 1 >= 0 && (a[row - 1][col] == 0 || a[row - 1][col] == 2)) list.add(Pair(row - 1, col))
        if (row + 1 < a.size && (a[row + 1][col] == 0 || a[row + 1][col] == 2)) list.add(Pair(row + 1, col))
        if (col - 1 >= 0 && (a[row][col - 1] == 0 || a[row][col - 1] == 2)) list.add(Pair(row, col - 1))
        if (col + 1 < a[row].size && (a[row][col + 1] == 0 || a[row][col + 1] == 2)) list.add(Pair(row, col + 1))

        return list
    }
}

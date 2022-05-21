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
 * 1091. Shortest Path in Binary Matrix
 * @link https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
interface ShortestPathInBinaryMatrix {
    fun perform(grid: Array<IntArray>): Int
}

class ShortestPathInBinaryMatrixBFS : ShortestPathInBinaryMatrix {

    private val dir = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(1, -1),
        intArrayOf(-1, 1),
        intArrayOf(-1, -1),
        intArrayOf(1, 1)
    )

    override fun perform(grid: Array<IntArray>): Int {
        val m: Int = grid.size
        val n: Int = grid[0].size

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1
        }

        val visited = Array(m) { BooleanArray(n) }
        visited[0][0] = true
        val queue: Queue<IntArray> = LinkedList()
        queue.add(intArrayOf(0, 0))

        var ans = 0
        while (!queue.isEmpty()) {
            val size: Int = queue.size
            for (i in 0 until size) {
                val pop: IntArray = queue.remove()
                if (pop[0] == m - 1 && pop[1] == n - 1) {
                    return ans + 1
                }
                for (k in 0..7) {
                    val nextX = dir[k][0] + pop[0]
                    val nextY = dir[k][1] + pop[1]
                    val local = nextY in 0 until n && !visited[nextX][nextY] && grid[nextX][nextY] == 0
                    if (nextX in 0 until m && local) {
                        queue.add(intArrayOf(nextX, nextY))
                        visited[nextX][nextY] = true
                    }
                }
            }
            ans++
        }

        return -1
    }
}

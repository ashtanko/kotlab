/*
 * Copyright 2022 Alexey Shtanko
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
import kotlin.math.min

/**
 * 542. 01 Matrix
 * @link https://leetcode.com/problems/01-matrix/
 */
interface ZeroOneMatrix {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray>
}

/**
 * Approach 2: Using BFS
 */
class ZeroOneMatrixBFS : ZeroOneMatrix {
    private val dir = intArrayOf(0, 1, 0, -1, 0)

    override fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val m: Int = mat.size
        val n: Int = mat[0].size // The distance of cells is up to (M+N)

        val q: Queue<IntArray> = LinkedList()
        for (r in 0 until m) for (c in 0 until n) {
            if (mat[r][c] == 0) {
                q.offer(intArrayOf(r, c))
            } else {
                mat[r][c] = -1 // Marked as not processed yet!
            }
        }

        while (!q.isEmpty()) {
            val curr: IntArray = q.poll()
            val r = curr[0]
            val c = curr[1]
            for (i in 0..3) {
                val nr: Int = r + dir[i]
                val nc: Int = c + dir[i + 1]
                val local = nr < 0 || nr == m || nc < 0
                if (local || nc == n || mat[nr][nc] != -1) {
                    continue
                }
                mat[nr][nc] = mat[r][c] + 1
                q.offer(intArrayOf(nr, nc))
            }
        }
        return mat
    }
}

/**
 * Approach 3: Dynamic Programming
 */
class ZeroOneMatrixDP : ZeroOneMatrix {
    override fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val m: Int = mat.size
        val n: Int = mat.first().size
        val inf = m + n // The distance of cells is up to (M+N)

        for (r in 0 until m) {
            for (c in 0 until n) {
                if (mat[r][c] == 0) {
                    continue
                }
                var top = inf
                var left = inf
                if (r - 1 >= 0) {
                    top = mat[r - 1][c]
                }
                if (c - 1 >= 0) {
                    left = mat[r][c - 1]
                }
                mat[r][c] = min(top, left) + 1
            }
        }
        for (r in m - 1 downTo 0) {
            for (c in n - 1 downTo 0) {
                if (mat[r][c] == 0) {
                    continue
                }
                var bottom = inf
                var right = inf
                if (r + 1 < m) {
                    bottom = mat[r + 1][c]
                }
                if (c + 1 < n) {
                    right = mat[r][c + 1]
                }
                mat[r][c] = min(mat[r][c], min(bottom, right) + 1)
            }
        }
        return mat
    }
}

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
import kotlin.math.min

/**
 * 542. 01 Matrix
 * @see <a href="https://leetcode.com/problems/01-matrix/">Source</a>
 */
fun interface ZeroOneMatrix {
    operator fun invoke(mat: Array<IntArray>): Array<IntArray>
}

/**
 * Approach 2: Using BFS
 */
class ZeroOneMatrixBFS : ZeroOneMatrix {
    private val dir = intArrayOf(0, 1, 0, -1, 0)

    override fun invoke(mat: Array<IntArray>): Array<IntArray> {
        val q: Queue<IntArray> = LinkedList()

        initializeQueue(mat, q)

        while (q.isNotEmpty()) {
            processQueue(mat, q)
        }

        return mat
    }

    private fun initializeQueue(mat: Array<IntArray>, q: Queue<IntArray>) {
        for (r in mat.indices) {
            for (c in mat[0].indices) {
                if (mat[r][c] == 0) {
                    q.offer(intArrayOf(r, c))
                } else {
                    mat[r][c] = -1 // Marked as not processed yet!
                }
            }
        }
    }

    private fun processQueue(mat: Array<IntArray>, q: Queue<IntArray>) {
        val curr: IntArray = q.poll()
        val r = curr[0]
        val c = curr[1]

        for (i in 0..3) {
            val nr: Int = r + dir[i]
            val nc: Int = c + dir[i + 1]

            val local = nr < 0 || nr == mat.size || nc < 0 || nc == mat[0].size

            if (local || mat[nr][nc] != -1) {
                continue
            }

            mat[nr][nc] = mat[r][c] + 1
            q.offer(intArrayOf(nr, nc))
        }
    }
}

/**
 * Approach 3: Dynamic Programming
 */
class ZeroOneMatrixDP : ZeroOneMatrix {

    override fun invoke(mat: Array<IntArray>): Array<IntArray> {
        val m: Int = mat.size
        val n: Int = mat.firstOrNull()?.size ?: 0

        fillTopLeft(mat, m, n)
        fillBottomRight(mat, m, n)

        return mat
    }

    private fun fillTopLeft(mat: Array<IntArray>, m: Int, n: Int) {
        val inf = m + n

        for (r in 0 until m) {
            for (c in 0 until n) {
                if (mat[r][c] == 0) continue

                val top = if (r - 1 >= 0) mat[r - 1][c] else inf
                val left = if (c - 1 >= 0) mat[r][c - 1] else inf

                mat[r][c] = min(top, left) + 1
            }
        }
    }

    private fun fillBottomRight(mat: Array<IntArray>, m: Int, n: Int) {
        val inf = m + n

        for (r in m - 1 downTo 0) {
            for (c in n - 1 downTo 0) {
                if (mat[r][c] == 0) continue

                val bottom = if (r + 1 < m) mat[r + 1][c] else inf
                val right = if (c + 1 < n) mat[r][c + 1] else inf

                mat[r][c] = min(mat[r][c], min(bottom, right) + 1)
            }
        }
    }
}

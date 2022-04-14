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

import java.util.Deque
import java.util.LinkedList
import java.util.Queue

/**
 * 1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix
 * @link https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/
 */
interface MinMatrixFlips {
    fun perform(mat: Array<IntArray>): Int
}

class MinMatrixFlipsBFS : MinMatrixFlips {

    private val dirs =
        arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1))

    override fun perform(mat: Array<IntArray>): Int {
        return bfs(mat)
    }

    private fun bfs(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        var steps = 0
        val initialState = getInitialState(mat, m, n) // create initial state of matrix based on input
        val queue: Queue<Int> = LinkedList()
        val visited: MutableSet<Int> = HashSet()
        queue.add(initialState)
        while (!queue.isEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val currState = queue.poll()
                if (currState == 0) { // reached final state
                    return steps
                }
                val nextStates = getNextStates(currState, m, n) // find next states based on current state
                for (nextState in nextStates) {
                    if (!visited.contains(nextState)) {
                        queue.add(nextState)
                        visited.add(nextState)
                    }
                }
            }
            steps++
        }
        return -1
    }

    private fun getNextStates(currStates: Int, m: Int, n: Int): List<Int> {
        val nextStates: MutableList<Int> = ArrayList()
        for (i in 0 until m) {
            for (j in 0 until n) {
                var nextState = currStates
                for (dir in dirs) {
                    val nextRow = i + dir[0]
                    val nextCol = j + dir[1]
                    if (isInBoundary(nextRow, nextCol, m, n)) { // flip all neighbors
                        nextState = nextState xor (1 shl nextRow * n) + nextCol
                    }
                }
                nextStates.add(nextState)
            }
        }
        return nextStates
    }

    private fun isInBoundary(row: Int, col: Int, m: Int, n: Int): Boolean {
        return row in 0 until m && col >= 0 && col < n
    }

    private fun getInitialState(mat: Array<IntArray>, m: Int, n: Int): Int {
        var initialState = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                initialState = initialState or (mat[i][j] shl i * n) + j
            }
        }
        return initialState
    }
}

class MinMatrixFlipsDFS : MinMatrixFlips {
    private val d = intArrayOf(0, 0, 1, 0, -1, 0)

    override fun perform(mat: Array<IntArray>): Int {
        var start = 0
        val m: Int = mat.size
        val n: Int = mat[0].size
        for (i in 0 until m) for (j in 0 until n) start = start or (mat[i][j] shl i * n) + j
        val stk: Deque<IntArray> = LinkedList()
        stk.push(intArrayOf(start, 0))
        val seenSteps: MutableMap<Int, Int> = HashMap()
        seenSteps[start] = 0
        while (!stk.isEmpty()) {
            val a = stk.pop()
            val cur = a[0]
            val step = a[1]
            for (i in 0 until m) {
                for (j in 0 until n) {
                    var next = cur
                    for (k in 0..4) {
                        val r = i + d[k]
                        val c = j + d[k + 1]
                        if (r in 0 until m && c >= 0 && c < n) {
                            next = next xor (1 shl r * n) + c
                        }
                    }
                    if (seenSteps.getOrDefault(next, Int.MAX_VALUE) > step + 1) {
                        seenSteps[next] = step + 1
                        stk.push(intArrayOf(next, step + 1))
                    }
                }
            }
        }
        return seenSteps.getOrDefault(0, -1)
    }
}

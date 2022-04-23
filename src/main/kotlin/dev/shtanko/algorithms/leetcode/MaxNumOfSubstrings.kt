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

import dev.shtanko.algorithms.leetcode.MaxNumOfSubstrings.Companion.ARR_SIZE
import java.util.Stack
import kotlin.math.max
import kotlin.math.min

/**
 * 1520. Maximum Number of Non-Overlapping Substrings
 * @link https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
 */
interface MaxNumOfSubstrings {
    fun perform(s: String): List<String>

    companion object {
        const val ARR_SIZE = 26
    }
}

class MaxNumOfSubstringsGreedy : MaxNumOfSubstrings {
    override fun perform(s: String): List<String> {
        val len: Int = s.length
        val range = Array(ARR_SIZE) { IntArray(2) }
        for (i in 0 until ARR_SIZE) range[i] = intArrayOf(len, 0)
        val st: Stack<IntArray> = Stack()
        val res: MutableList<String> = ArrayList()
        for (i in 0 until len) {
            val idx: Int = s[i] - 'a'
            range[idx][0] = min(i, range[idx][0])
            range[idx][1] = max(i, range[idx][1])
        }
        for (i in 0 until len) {
            val idx: Int = s[i] - 'a'
            if (range[idx][0] != i) continue
            val l = range[idx][0]
            val tail = range[idx][1]
            val r = getRightMost(l, tail, range, s)
            if (r < 0) continue
            while (!st.isEmpty() && l >= st.peek()[0] && r <= st.peek()[1]) st.pop()
            st.push(intArrayOf(l, r))
        }
        while (!st.isEmpty()) res.add(s.substring(st.peek()[0], st.pop()[1] + 1))
        return res
    }

    private fun getRightMost(l: Int, r: Int, range: Array<IntArray>, s: String): Int {
        var right = r
        for (i in l + 1 until right) {
            val idx = s[i].code - 'a'.code
            if (range[idx][0] < l) return -1
            right = max(right, range[idx][1])
        }
        return right
    }
}

class MaxNumOfSubstringsKosaraju : MaxNumOfSubstrings {
    override fun perform(s: String): List<String> {
        // some nasty pre-compute in order to build the graph in O(N) time
        val mins = IntArray(ARR_SIZE) { Int.MAX_VALUE }
        val maxs = IntArray(ARR_SIZE) { -1 }
        val exists = BooleanArray(ARR_SIZE)
        val prefixSum = Array(s.length + 1) {
            IntArray(
                ARR_SIZE
            )
        }
        for (i in s.indices) {
            System.arraycopy(prefixSum[i], 0, prefixSum[i + 1], 0, ARR_SIZE)
            prefixSum[i + 1][s[i] - 'a'] += 1
            mins[s[i] - 'a'] = min(mins[s[i] - 'a'], i)
            maxs[s[i] - 'a'] = maxs[s[i] - 'a'].coerceAtLeast(i)
            exists[s[i] - 'a'] = true
        }
        // build graph, using adjacency matrix
        val graph = Array(ARR_SIZE) { BooleanArray(ARR_SIZE) }
        for (i in 0 until ARR_SIZE) {
            if (exists[i]) {
                for (j in 0 until ARR_SIZE) {
                    if (prefixSum[maxs[i] + 1][j] - prefixSum[mins[i]][j] > 0) {
                        graph[i][j] = true
                    }
                }
            }
        }

        // kosaraju algorithm to find scc
        val stack = Stack()
        val visited = BooleanArray(ARR_SIZE)
        for (i in 0 until ARR_SIZE) {
            if (exists[i] && !visited[i]) {
                dfs(i, graph, stack, visited)
            }
        }
        var batch = 0 // 'id' of each SCC

        val batches = IntArray(ARR_SIZE) { -1 }
        val degree = IntArray(ARR_SIZE) // out-degree of each SCC

        while (!stack.isEmpty) {
            val v = stack.pop()
            if (batches[v] < 0) {
                dfs(v, graph, batches, batch, degree)
                batch++
            }
        }

        val res: MutableList<String> = ArrayList()
        for (i in batch - 1 downTo 0) {
            if (degree[i] == 0) {
                var min = Int.MAX_VALUE
                var max = -1
                for (j in 0 until ARR_SIZE) {
                    if (batches[j] == i) {
                        min = min(mins[j], min)
                        max = max(maxs[j], max)
                    }
                }
                res.add(s.substring(min, max + 1))
            }
        }

        return res
    }

    private fun dfs(v: Int, graph: Array<BooleanArray>, stack: Stack, visited: BooleanArray) {
        if (!visited[v]) {
            visited[v] = true
            for (i in 0 until ARR_SIZE) {
                if (graph[v][i] && !visited[i]) {
                    dfs(i, graph, stack, visited)
                }
            }
            stack.push(v)
        }
    }

    private fun dfs(v: Int, graph: Array<BooleanArray>, batches: IntArray, batch: Int, degree: IntArray) {
        if (batches[v] < 0) {
            batches[v] = batch
            for (i in 0 until ARR_SIZE) {
                if (graph[i][v]) {
                    dfs(i, graph, batches, batch, degree)
                }
            }
        } else {
            if (batches[v] != batch) {
                degree[batches[v]] += 1
            }
        }
    }

    private class Stack {
        var values = IntArray(ARR_SIZE)
        var top = 0
        fun push(value: Int) {
            values[top++] = value
        }

        fun pop(): Int {
            top--
            return values[top]
        }

        val isEmpty: Boolean
            get() = top == 0
    }
}

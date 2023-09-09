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
 * 2316. Count Unreachable Pairs of Nodes in an Undirected Graph
 * @see <a href="https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph">
 *     leetcode page</a>
 */
fun interface CountUnreachablePairs {
    fun countPairs(n: Int, edges: Array<IntArray>): Long
}

class CountUnreachablePairsDFS : CountUnreachablePairs {

    private val x: MutableList<MutableList<Int>> = ArrayList()

    override fun countPairs(n: Int, edges: Array<IntArray>): Long {
        for (i in 0 until n) x.add(ArrayList())
        for (edge in edges) {
            x[edge[0]].add(edge[1]) // make graph
            x[edge[1]].add(edge[0])
        }

        var res: Long = 0
        var sum = n.toLong()
        val visited = BooleanArray(n)
        for (i in 0 until n) if (!visited[i]) {
            val curr = dfs(i, visited, IntArray(1)) // find size of connected component
            sum -= curr
            res += curr * sum
        }
        return res
    }

    private fun dfs(node: Int, visited: BooleanArray, count: IntArray): Int {
        if (visited[node]) return count[0]
        visited[node] = true
        count[0]++
        for (curr in x[node]) dfs(curr, visited, count)
        return count[0]
    }
}

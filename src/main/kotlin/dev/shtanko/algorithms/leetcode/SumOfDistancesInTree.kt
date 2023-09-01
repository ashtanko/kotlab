/*
 * Copyright 2020 Oleksii Shtanko
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
 * 834. Sum of Distances in Tree
 * @see <a href="https://leetcode.com/problems/sum-of-distances-in-tree/description/">leetcode page</a>
 */
class SumOfDistancesInTree {

    private lateinit var ans: IntArray
    private lateinit var count: IntArray
    private var graph: MutableList<MutableSet<Int>> = ArrayList()
    private var n = 0

    operator fun invoke(n: Int, edges: Array<IntArray>): IntArray {
        this.n = n
        ans = IntArray(n)
        count = IntArray(n) { 1 }

        for (i in 0 until n) {
            graph.add(HashSet())
        }
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        dfs(0, -1)
        dfs2(0, -1)
        return ans
    }

    private fun dfs(node: Int, parent: Int) {
        for (child in graph[node]) if (child != parent) {
            dfs(child, node)
            count[node] += count[child]
            ans[node] += ans[child] + count[child]
        }
    }

    private fun dfs2(node: Int, parent: Int) {
        for (child in graph[node]) if (child != parent) {
            ans[child] = ans[node] - count[child] + n - count[child]
            dfs2(child, node)
        }
    }
}

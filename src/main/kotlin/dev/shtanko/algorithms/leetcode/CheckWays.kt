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
 * 1719. Number Of Ways To Reconstruct A Tree
 * @link https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/
 */
interface CheckWays {
    fun perform(pairs: Array<IntArray>): Int
}

class CheckWaysDFS : CheckWays {

    var result = 1

    override fun perform(pairs: Array<IntArray>): Int {
        result = 1
        val graph: HashMap<Int, HashSet<Int>> = HashMap()

        for (pair in pairs) {
            graph.computeIfAbsent(pair[0]) { HashSet() }.add(pair[1])
            graph.computeIfAbsent(pair[1]) { HashSet() }.add(pair[0])
        }

        val nodes: ArrayList<Int> = ArrayList(graph.keys)
        nodes.sortWith { a, b ->
            graph[a]!!.size - graph[b]!!.size
        }

        val tree: HashMap<Int, ArrayList<Int>> = HashMap()
        var root = -1

        for (l in nodes.indices) {
            var p = l + 1
            val leaf = nodes[l]
            while (p < nodes.size && !graph[nodes[p]]!!.contains(leaf)) p++
            if (p < nodes.size) {
                tree.computeIfAbsent(nodes[p]) { ArrayList() }.add(leaf)
                if (graph[nodes[p]]?.size == graph[leaf]?.size) {
                    result = 2
                }
            } else {
                root = if (root == -1) {
                    leaf
                } else {
                    return 0
                }
            }
        }

        dfs(root, 0, tree, graph, HashSet())

        return result
    }

    fun dfs(
        root: Int,
        depth: Int,
        tree: HashMap<Int, ArrayList<Int>>,
        graph: HashMap<Int, HashSet<Int>>,
        visited: HashSet<Int?>,
    ): Int {
        if (result == 0) return -1
        if (visited.contains(root)) {
            result = 0
            return -1
        }
        visited.add(root)
        var descendantsNum = 0
        for (node in tree.getOrDefault(root, ArrayList())) descendantsNum += dfs(
            node,
            depth + 1,
            tree,
            graph,
            visited,
        )
        if (descendantsNum + depth != graph[root]?.size) {
            result = 0
            return -1
        }
        return descendantsNum + 1
    }
}

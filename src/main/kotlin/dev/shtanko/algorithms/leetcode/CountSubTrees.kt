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
 * 1519. Number of Nodes in the Sub-Tree With the Same Label
 * @see <a href="https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/">leetcode page</a>
 */
interface CountSubTrees {
    operator fun invoke(n: Int, edges: Array<IntArray>, labels: String): IntArray
}

class CountSubTreesDFS : CountSubTrees {
    override operator fun invoke(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val g: MutableMap<Int, MutableList<Int>> = HashMap()
        for (e in edges) {
            g.computeIfAbsent(e[0]) { ArrayList() }.add(e[1])
            g.computeIfAbsent(e[1]) { ArrayList() }.add(e[0])
        }
        val ans = IntArray(n)
        dfs(g, 0, -1, labels, ans)
        return ans
    }

    private fun dfs(g: Map<Int, List<Int>>, node: Int, parent: Int, labels: String, ans: IntArray): IntArray {
        val cnt = IntArray(ALPHABET_LETTERS_COUNT)
        val c = labels[node]
        for (child in g[node] ?: emptyList()) {
            if (child != parent) {
                val sub = dfs(g, child, node, labels, ans)
                for (i in 0 until ALPHABET_LETTERS_COUNT) {
                    cnt[i] += sub[i]
                }
            }
        }
        ++cnt[c.code - 'a'.code]
        ans[node] = cnt[c.code - 'a'.code]
        return cnt
    }
}

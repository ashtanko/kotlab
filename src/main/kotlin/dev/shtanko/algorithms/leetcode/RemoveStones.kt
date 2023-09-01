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
 * 947. Most Stones Removed with Same Row or Column
 * @see <a href="https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/">leetcode page</a>
 */
fun interface RemoveStones {
    operator fun invoke(stones: Array<IntArray>): Int
}

class RemoveStonesMap : RemoveStones {

    private val f: MutableMap<Int, Int> = HashMap()
    private var islands = 0

    override operator fun invoke(stones: Array<IntArray>): Int {
        for (i in stones.indices) union(stones[i][0], stones[i][1].inv())
        return stones.size - islands
    }

    fun find(x: Int): Int {
        if (f.putIfAbsent(x, x) == null) {
            islands++
        }
        if (x != f[x]) {
            f[x]?.let {
                f[x] = find(it)
            }
        }
        return f.getOrDefault(x, 0)
    }

    private fun union(x: Int, y: Int) {
        var x0 = x
        var y0 = y
        x0 = find(x0)
        y0 = find(y0)
        if (x0 != y0) {
            f[x0] = y0
            islands--
        }
    }
}

class RemoveStonesDFS : RemoveStones {
    override operator fun invoke(stones: Array<IntArray>): Int {
        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        for (stone in stones) {
            graph.computeIfAbsent(stone[0]) { ArrayList() }.add(stone[1].inv())
            graph.computeIfAbsent(stone[1].inv()) { ArrayList() }.add(stone.first())
        }
        var numOfComponent = 0
        val visited: MutableSet<Int> = HashSet()
        for (stone in stones) {
            for (i in 0..1) {
                val s = if (i == 0) stone[0] else stone[1].inv()
                if (!visited.contains(s)) {
                    numOfComponent++
                    dfs(s, graph, visited)
                }
            }
        }
        return stones.size - numOfComponent
    }

    private fun dfs(stone: Int, graph: Map<Int, List<Int>>, visited: MutableSet<Int>) {
        if (visited.add(stone)) {
            for (next in graph.getOrDefault(stone, emptyList())) {
                dfs(next, graph, visited)
            }
        }
    }
}

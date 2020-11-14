package dev.shtanko.algorithms.leetcode

import java.util.ArrayList

class SumOfDistancesInTree {

    private lateinit var ans: IntArray
    private lateinit var count: IntArray
    private var graph: MutableList<MutableSet<Int>> = ArrayList()
    private var n = 0

    fun perform(n: Int, edges: Array<IntArray>): IntArray {
        this.n = n
        ans = IntArray(n)
        count = IntArray(n) { 1 }

        for (i in 0 until n) graph.add(HashSet())
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

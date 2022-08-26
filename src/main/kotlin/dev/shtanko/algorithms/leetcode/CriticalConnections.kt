/*
 * Copyright 2021 Oleksii Shtanko
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
import kotlin.math.max
import kotlin.math.min

/**
 * 1192. Critical Connections in a Network
 * @link https://leetcode.com/problems/critical-connections-in-a-network
 */
interface CriticalConnections {
    fun perform(n: Int, connections: List<List<Int>>): List<List<Int>>
}

/**
 * Approach: Depth First Search for Cycle Detection
 */
class CycleDetection : CriticalConnections {

    private var graph: MutableMap<Int, MutableList<Int>> = HashMap()
    private var rank: MutableMap<Int, Int?> = HashMap()
    private var connDict: MutableMap<Pair<Int, Int>, Boolean> = HashMap()

    override fun perform(n: Int, connections: List<List<Int>>): List<List<Int>> {
        formGraph(n, connections)
        this.dfs(0, 0)

        val result: MutableList<List<Int>> = ArrayList()
        for (criticalConnection in connDict.keys) {
            result.add(listOf(criticalConnection.first, criticalConnection.second))
        }

        return result
    }

    private fun dfs(node: Int, discoveryRank: Int): Int {
        // That means this node is already visited. We simply return the rank.
        if (rank[node] != null) {
            return rank[node]!!
        }

        // Update the rank of this node.
        rank[node] = discoveryRank

        // This is the max we have seen till now. So we start with this instead of INT_MAX or something.
        var minRank = discoveryRank + 1
        for (neighbor in graph[node]!!) {
            // Skip the parent.
            val neighRank = rank[neighbor]
            if (neighRank != null && neighRank == discoveryRank - 1) {
                continue
            }

            // Recurse on the neighbor.
            val recursiveRank = this.dfs(neighbor, discoveryRank + 1)

            // Step 1, check if this edge needs to be discarded.
            if (recursiveRank <= discoveryRank) {
                val sortedU = min(node, neighbor)
                val sortedV = max(node, neighbor)
                connDict.remove(Pair(sortedU, sortedV))
            }

            // Step 2, update the minRank if needed.
            minRank = min(minRank, recursiveRank)
        }
        return minRank
    }

    private fun formGraph(n: Int, connections: List<List<Int>>) {
        // Default rank for unvisited nodes is "null"
        for (i in 0 until n) {
            graph[i] = ArrayList()
            rank[i] = null
        }
        for (edge in connections) {
            // Bidirectional edges
            val u = edge[0]
            val v = edge[1]
            graph[u]?.add(v)
            graph[v]?.add(u)
            val sortedU = min(u, v)
            val sortedV = max(u, v)
            connDict[Pair(sortedU, sortedV)] = true
        }
    }
}

class CriticalConnectionsGraph : CriticalConnections {
    var time = 0
    private val bridges = ArrayList<List<Int>>()

    override fun perform(n: Int, connections: List<List<Int>>): List<List<Int>> {
        val graph = buildGraph(n, connections)
        graph.vertices.forEach {
            if (it.visited.not()) dfs(it, graph)
        }
        return bridges
    }

    private fun dfs(u: Vertex, graph: Graph) {
        time++
        u.d = time
        u.low = time
        u.visited = true
        var child = 0
        for (v in graph.adjList[u.id]) {
            if (v.visited.not()) {
                child++
                v.parent = u.id
                dfs(v, graph)
                u.low = minOf(u.low, v.low)
                if (u.parent == -1 && child > 1) {
                    u.articulationPoint = true
                } else if (u.parent != -1 && v.low >= u.d) {
                    u.articulationPoint = true
                }
                if (v.low > u.d) bridges.add(listOf(u.id, v.id))
            } else if (u.parent != v.id) {
                u.low = minOf(u.low, v.d)
            }
        }
    }

    private fun buildGraph(n: Int, connections: List<List<Int>>): Graph {
        val graph = Graph(n)
        connections.forEach { path ->
            val (from, to) = path[0] to path[1]
            graph.addEdge(from, to)
        }
        return graph
    }

    private data class Vertex(
        val id: Int,
        var d: Int = 0,
        var low: Int = Int.MAX_VALUE,
        var parent: Int = -1,
        var visited: Boolean = false,
        var articulationPoint: Boolean = false,
    )

    private class Graph(n: Int) {

        val vertices = Array(n) { i -> Vertex(i) }

        val adjList = Array(n) { LinkedList<Vertex>() }

        fun addEdge(from: Int, to: Int) {
            val (f, t) = vertices[from] to vertices[to]
            adjList[from].add(t)
            adjList[to].add(f)
        }
    }
}

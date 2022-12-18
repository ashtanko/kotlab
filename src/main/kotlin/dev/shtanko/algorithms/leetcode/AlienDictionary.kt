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
import java.util.Queue
import kotlin.math.min

/**
 * 269. Alien Dictionary
 * @link https://leetcode.com/problems/alien-dictionary/solution/
 */
interface AlienDictionary {
    fun alienOrder(words: Array<String>): String
}

/**
 * Approach 1: Breadth-First Search
 * Time complexity : O(C).
 */
class AlienDictionaryBFS : AlienDictionary {
    override fun alienOrder(words: Array<String>): String {
        // Step 0: Create data structures and find all unique letters.
        val adjList: MutableMap<Char, MutableList<Char>> = HashMap()
        val counts: MutableMap<Char, Int> = HashMap()
        for (word in words) {
            for (c in word.toCharArray()) {
                counts[c] = 0
                adjList[c] = ArrayList()
            }
        }

        // Step 1: Find all edges.
        for (i in 0 until words.size - 1) {
            val word1 = words[i]
            val word2 = words[i + 1]
            // Check that word2 is not a prefix of word1.
            if (word1.length > word2.length && word1.startsWith(word2)) {
                return ""
            }
            // Find the first non match and insert the corresponding relation.
            for (j in 0 until min(word1.length, word2.length)) {
                if (word1[j] != word2[j]) {
                    adjList[word1[j]]?.add(word2[j])
                    counts[word2[j]] = counts.getOrDefault(word2[j], 0).plus(1)
                    break
                }
            }
        }

        // Step 2: Breadth-first search.
        val sb = StringBuilder()
        val queue: Queue<Char> = LinkedList()
        for (c in counts.keys) {
            if (counts[c] == 0) {
                queue.add(c)
            }
        }
        while (!queue.isEmpty()) {
            val c: Char = queue.remove()
            sb.append(c)
            for (next in adjList.getOrDefault(c, emptyList())) {
                counts[next] = counts.getOrDefault(next, 0) - 1
                if (counts[next] == 0) {
                    queue.add(next)
                }
            }
        }

        return if (sb.length < counts.size) {
            ""
        } else {
            sb.toString()
        }
    }
}

/**
 * Approach 2: Depth-First Search
 * Time complexity : O(C).
 */
class AlienDictionaryDFS : AlienDictionary {

    override fun alienOrder(words: Array<String>): String {
        val adj = Array(N) { BooleanArray(N) }
        val visited = IntArray(N) { -1 }
        buildGraph(words, adj, visited)

        val sb = StringBuilder()
        for (i in 0 until N) {
            // unvisited
            if (visited[i] == 0) {
                if (!dfs(adj, visited, sb, i)) return ""
            }
        }
        return sb.reverse().toString()
    }

    fun dfs(adj: Array<BooleanArray>, visited: IntArray, sb: StringBuilder, i: Int): Boolean {
        visited[i] = 1 // 1 = visiting
        for (j in 0 until N) {
            if (adj[i][j]) {
                if (visited[j] == 1) return false
                if (visited[j] == 0) {
                    if (!dfs(adj, visited, sb, j)) return false
                }
            }
        }
        visited[i] = 2 // 2 = visited
        sb.append((i + 'a'.code).toChar())
        return true
    }

    private fun buildGraph(words: Array<String>, adj: Array<BooleanArray>, visited: IntArray) {
        if (words.isEmpty()) return
        var pre = words[0].toCharArray()
        for (k in pre.indices) visited[pre[k] - 'a'] = 0
        for (i in 1 until words.size) {
            val cur = words[i].toCharArray()
            for (k in cur.indices) visited[cur[k] - 'a'] = 0
            val length = min(pre.size, cur.size)
            for (j in 0 until length) {
                if (cur[j] != pre[j]) {
                    adj[pre[j] - 'a'][cur[j] - 'a'] = true
                    break
                }
            }
            pre = cur
        }
    }

    companion object {
        private const val N = 26
    }
}

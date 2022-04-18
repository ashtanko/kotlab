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

import dev.shtanko.algorithms.extensions.swap
import java.util.ArrayList

class SimilarStringGroups {

    fun perform(strings: Array<String>): Int {
        val n: Int = strings.size
        val w: Int = strings[0].length
        val dsu = DSU(n)

        if (n < w * w) { // If few words, then check for pairwise similarity: O(N^2 W)
            for (i in 0 until n) for (j in i + 1 until n) if (similar(strings[i], strings[j])) dsu.union(i, j)
        } else { // If short words, check all neighbors: O(N W^3)
            val buckets: MutableMap<String, MutableList<Int>> = HashMap()
            for (i in 0 until n) {
                val l: CharArray = strings[i].toCharArray()
                for (j0 in l.indices) {
                    for (j1 in j0 + 1 until l.size) {
                        l.swap(j0, j1)
                        val sb = StringBuilder()
                        for (c in l) sb.append(c)
                        buckets.computeIfAbsent(sb.toString()) { ArrayList() }.add(i)
                        l.swap(j0, j1)
                    }
                }
            }
            for (i1 in strings.indices) if (buckets.containsKey(strings[i1])) for (i2 in buckets[strings[i1]]!!) {
                dsu.union(i1, i2)
            }
        }

        var ans = 0
        for (i in 0 until n) if (dsu.parent[i] == i) ans++

        return ans
    }

    private fun similar(word1: String, word2: String): Boolean {
        var diff = 0
        for (i in word1.indices) if (word1[i] != word2[i]) diff++
        return diff <= 2
    }
}

internal class DSU(n: Int) {

    var parent: IntArray = IntArray(n)

    init {
        for (i in 0 until n) parent[i] = i
    }

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        parent[find(x)] = find(y)
    }
}

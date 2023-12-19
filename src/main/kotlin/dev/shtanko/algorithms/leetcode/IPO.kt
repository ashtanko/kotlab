/*
 * Copyright 2023 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import java.util.Collections
import java.util.PriorityQueue

/**
 * 502. IPO
 * @see <a href="https://leetcode.com/problems/ipo/">Source</a>
 */
fun interface IPO {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int
}

class IPOGreedy : IPO {

    override fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val n = profits.size
        val projects = Array(n) { Pair() }
        for (i in 0 until n) {
            projects[i] = Pair(capital[i], profits[i])
        }
        projects.sort()
        val priority: PriorityQueue<Int> = PriorityQueue<Int>(Collections.reverseOrder())
        var j = 0
        var ans = w
        for (i in 0 until k) {
            while (j < n && projects[j].capital <= ans) {
                priority.add(projects[j++].profit)
            }
            if (priority.isEmpty()) {
                break
            }
            ans += priority.poll()
        }
        return ans
    }

    private data class Pair(var capital: Int = 0, var profit: Int = 0) : Comparable<Pair> {
        override fun compareTo(other: Pair): Int {
            return capital - other.capital
        }
    }
}

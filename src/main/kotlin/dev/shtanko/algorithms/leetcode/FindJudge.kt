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
 * Find the Town Judge.
 * @see <a href="https://leetcode.com/problems/find-the-town-judge/">leetcode page</a>
 */
interface FindJudge {
    fun perform(n: Int, trust: Array<IntArray>): Int
}

class FindJudgeTwoArrays : FindJudge {
    override fun perform(n: Int, trust: Array<IntArray>): Int {
        if (trust.size < n - 1) {
            return -1
        }
        val indegrees = IntArray(n + 1)
        val outdegrees = IntArray(n + 1)

        for (relation in trust) {
            outdegrees[relation[0]]++
            indegrees[relation[1]]++
        }
        for (i in 1..n) {
            if (indegrees[i] == n - 1 && outdegrees[i] == 0) {
                return i
            }
        }
        return -1
    }
}

class FindJudgeOneArray : FindJudge {
    override fun perform(n: Int, trust: Array<IntArray>): Int {
        if (trust.size < n - 1) {
            return -1
        }
        val trustScores = IntArray(n + 1)
        for (relation in trust) {
            trustScores[relation[0]]--
            trustScores[relation[1]]++
        }

        for (i in 1..n) {
            if (trustScores[i] == n - 1) {
                return i
            }
        }
        return -1
    }
}

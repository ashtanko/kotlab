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

/**
 * 294. Flip Game II
 * @link https://leetcode.com/problems/flip-game-ii/
 */
interface FlipGame2 {
    fun canWin(currentState: String): Boolean
}

class FG2BruteForce : FlipGame2 {
    override fun canWin(currentState: String): Boolean {
        for (i in 0 until currentState.length - 1) {
            if (currentState[i] == '+' && currentState[i + 1] == '+' && !canWin(
                    currentState.substring(0, i) + "--" + currentState.substring(i + 2)
                )
            ) {
                return true
            }
        }
        return false
    }
}

/**
 * Backtracking solution with time optimization through DP
 */
class FG2Backtracking : FlipGame2 {
    override fun canWin(currentState: String): Boolean {
        if (currentState.length < 2) {
            return false
        }
        val winMap = HashMap<String, Boolean>()
        return helper(currentState, winMap)
    }

    private fun helper(s: String, winMap: HashMap<String, Boolean>): Boolean {
        if (winMap.containsKey(s)) {
            return winMap[s]!!
        }
        for (i in 0 until s.length - 1) {
            if (s.startsWith("++", i)) {
                val t = s.substring(0, i) + "--" + s.substring(i + 2)
                if (!helper(t, winMap)) {
                    winMap[s] = true
                    return true
                }
            }
        }
        winMap[s] = false
        return false
    }
}

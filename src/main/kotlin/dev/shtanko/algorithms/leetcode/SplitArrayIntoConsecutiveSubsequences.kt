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

import java.util.LinkedList
import java.util.Queue

/**
 * Split Array into Consecutive Subsequences.
 */
interface SplitArrayIntoConsecutiveSubsequences {
    fun isPossible(nums: IntArray): Boolean
}

/**
 * Approach #1: Opening and Closing Event.
 * Time Complexity: O(N).
 * Space Complexity: O(N).
 */
class SplitArrayIntoConsecutiveSubsequencesQueue : SplitArrayIntoConsecutiveSubsequences {
    override fun isPossible(nums: IntArray): Boolean {
        var prev: Int? = null
        var prevCount = 0
        val starts: Queue<Int> = LinkedList()
        var anchor = 0
        for (i in nums.indices) {
            val t = nums[i]
            if (i == nums.size - 1 || nums[i + 1] != t) {
                val count = i - anchor + 1
                if (prev != null && t - prev != 1) {
                    while (prevCount-- > 0) if (prev < starts.poll() + 2) return false
                    prev = null
                }
                if (prev == null || t - prev == 1) {
                    while (prevCount > count) {
                        prevCount--
                        if (t - 1 < starts.poll() + 2) return false
                    }
                    while (prevCount++ < count) starts.add(t)
                }
                prev = t
                prevCount = count
                anchor = i + 1
            }
        }

        while (prevCount-- > 0) if (nums[nums.size - 1] < starts.poll() + 2) return false
        return true
    }
}

/**
 * Approach #2: Greedy.
 * Time Complexity: O(N).
 * Space Complexity: O(N).
 */
class SplitArrayIntoConsecutiveSubsequencesGreedy : SplitArrayIntoConsecutiveSubsequences {
    override fun isPossible(nums: IntArray): Boolean {
        val count = CounterMap()
        val tails = CounterMap()

        for (x in nums) count.add(x, 1)

        for (x in nums) {
            if (count[x] == 0) {
                continue
            } else if (tails[x] > 0) {
                tails.add(x, -1)
                tails.add(x + 1, 1)
            } else if (count[x + 1] > 0 && count[x + 2] > 0) {
                count.add(x + 1, -1)
                count.add(x + 2, -1)
                tails.add(x + 3, 1)
            } else {
                return false
            }
            count.add(x, -1)
        }
        return true
    }
}

internal class CounterMap : HashMap<Int?, Int?>() {
    operator fun get(k: Int): Int {
        return if (containsKey(k)) super.get(k)!! else 0
    }

    fun add(k: Int, v: Int) {
        put(k, get(k) + v)
    }
}

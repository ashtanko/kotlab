/*
 * Copyright 2020 Alexey Shtanko
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

interface TwoSumStrategy {
    fun perform(nums: IntArray, target: Int): IntArray
}

class TwoSumBruteForce : TwoSumStrategy {
    override fun perform(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[j] == target - nums[i]) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
        // or throw IllegalArgumentException("No two sum solution")
    }
}

class TwoSumTwoPassHashTable : TwoSumStrategy {
    override fun perform(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = HashMap()
        for (i in nums.indices) {
            map[nums[i]] = i
        }
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement) && map[complement] != i) {
                return intArrayOf(i, map[complement]!!)
            }
        }
        return intArrayOf()
        // or throw IllegalArgumentException("No two sum solution")
    }
}

class TwoSumOnePassHashTable : TwoSumStrategy {
    override fun perform(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = HashMap()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
        // or throw IllegalArgumentException("No two sum solution")
    }
}

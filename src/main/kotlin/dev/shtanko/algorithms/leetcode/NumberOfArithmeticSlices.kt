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
 * 446. Arithmetic Slices II - Subsequence
 * @see <a href="https://leetcode.com/problems/arithmetic-slices-ii-subsequence/">leetcode page</a>
 */
interface NumberOfArithmeticSlices {
    fun perform(nums: IntArray): Int
}

class NumberOfArithmeticSlicesBruteForce : NumberOfArithmeticSlices {

    private var n = 0
    private var ans = 0

    override fun perform(nums: IntArray): Int {
        n = nums.size
        ans = 0
        val cur: MutableList<Long> = ArrayList()
        dfs(0, nums, cur)
        return ans
    }

    private fun dfs(dep: Int, nums: IntArray, cur: MutableList<Long>) {
        if (dep == n) {
            if (cur.size < 3) {
                return
            }
            val diff = cur[1] - cur[0]
            for (i in 1 until cur.size) {
                if (cur[i] - cur[i - 1] != diff) {
                    return
                }
            }
            ans++
            return
        }
        dfs(dep + 1, nums, cur)
        cur.add(nums[dep].toLong())
        dfs(dep + 1, nums, cur)
        cur.remove(nums[dep].toLong())
    }
}

class NumberOfArithmeticSlicesDP : NumberOfArithmeticSlices {
    override fun perform(nums: IntArray): Int {
        val n: Int = nums.size
        var ans: Long = 0
        val cnt: Array<MutableMap<Int, Int>> = Array(n) { mutableMapOf() }
        for (i in 0 until n) {
            cnt[i] = HashMap(i)
            for (j in 0 until i) {
                val delta = nums[i] - nums[j]
                if (delta < Int.MIN_VALUE || delta > Int.MAX_VALUE) {
                    continue
                }
                val sum = cnt[j].getOrDefault(delta, 0)
                val origin = cnt[i].getOrDefault(delta, 0)
                cnt[i][delta] = origin + sum + 1
                ans += sum.toLong()
            }
        }
        return ans.toInt()
    }
}

class NumberOfArithmeticSlicesDP2 : NumberOfArithmeticSlices {
    override fun perform(nums: IntArray): Int {
        val n: Int = nums.size
        var ans = 0
        val dp: Array<HashMap<Long, Int>> = Array(n) { HashMap() }
        for (i in 0 until n) dp[i] = HashMap()
        for (i in 1 until n) {
            for (j in 0 until i) {
                val diff = nums[i].toLong() - nums[j].toLong()
                val cnt = dp[j].getOrDefault(diff, 0)
                dp[i][diff] = dp[i].getOrDefault(diff, 0) + cnt + 1

                ans += cnt
            }
        }
        return ans
    }
}

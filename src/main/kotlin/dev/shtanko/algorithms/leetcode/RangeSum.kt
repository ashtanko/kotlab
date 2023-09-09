/*
 * Copyright 2023 Oleksii Shtanko
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

import kotlin.math.max

/**
 * 1508. Range Sum of Sorted Subarray Sums
 * @see <a href="https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/">leetcode page</a>
 */
fun interface RangeSum {
    operator fun invoke(nums: IntArray, n: Int, left: Int, right: Int): Int
}

class RangeSumPrefixSum : RangeSum {
    override operator fun invoke(nums: IntArray, n: Int, left: Int, right: Int): Int {
        var res: Long = 0
        var sum: Long = 0
        val sums: MutableList<Long> = ArrayList()
        val pSum: MutableList<Long> = ArrayList() // sums - all sums of subarrays, pSum - prefix sums;
        var l = left

        pSum.add(0L)
        for (i in 0 until n) {
            sum += nums[i]
            pSum.add(sum)
            for (j in 0 until pSum.size - 1) sums.add(sum - pSum[j])
        }
        sums.sort()
        while (l <= right) res = (res + sums[l++ - 1]) % MOD
        return res.toInt()
    }
}

class RangeSumBinarySearch : RangeSum {
    override operator fun invoke(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val maxLeft = findMax(nums, left)
        val maxRight = findMax(nums, right)
        val rangeSumLeft = rangeSum(nums, maxLeft)
        val rangeSumRight = rangeSum(nums, maxRight)
        var ans = Math.floorMod(rangeSumRight[0] + (right - rangeSumRight[1]) * (maxRight + 1), MOD)
        ans = Math.floorMod(ans - (rangeSumLeft[0] + (left - rangeSumLeft[1] - 1) * (maxLeft + 1)), MOD)
        return ans
    }

    private fun findMax(nums: IntArray, cnt: Int): Int {
        var lo = 0
        var hi = 0
        for (v in nums) hi += v
        while (lo < hi) {
            val mid = lo + (hi - lo + 1) / 2
            val sum = rangeSum(nums, mid)
            if (sum[1] >= cnt) {
                hi = mid - 1
            } else {
                lo = mid
            }
        }
        return lo
    }

    // sum of various rangesums, including only those rangesum that are below max
    private fun rangeSum(nums: IntArray, max: Int): IntArray {
        var rangeSum = 0
        var rangeCnt = 0
        var lo = 0
        var hi = 0
        val n = nums.size
        var sum = 0
        var sumsum = 0
        while (lo < n) {
            while (hi < n && sum + nums[hi] <= max) {
                sum += nums[hi]
                sumsum = (sumsum + sum) % MOD
                ++hi
            }
            rangeSum = (rangeSum + sumsum) % MOD
            if (hi > lo) {
                sum -= nums[lo]
                sumsum = (sumsum - (hi - lo) * nums[lo] + MOD) % MOD
                rangeCnt += hi - lo
            }
            ++lo
            hi = max(hi, lo)
        }
        return intArrayOf(rangeSum, rangeCnt)
    }
}

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

/**
 * 974. Subarray Sums Divisible by K
 * @see <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">Source</a>
 */
fun interface SubarraysDivByK {
    operator fun invoke(nums: IntArray, k: Int): Int
}

class SubarraysDivByKMap : SubarraysDivByK {
    override operator fun invoke(nums: IntArray, k: Int): Int {
        val map: MutableMap<Int, Int> = HashMap()
        map[0] = 1
        var count = 0
        var sum = 0
        for (a in nums) {
            sum = (sum + a) % k
            if (sum < 0) sum += k // Because -1 % 5 = -1, but we need the positive mod 4
            count += map.getOrDefault(sum, 0)
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
        return count
    }
}

class SubarraysDivByKPrefixSum : SubarraysDivByK {
    override operator fun invoke(nums: IntArray, k: Int): Int {
        val map = IntArray(k)
        map[0] = 1
        var count = 0
        var sum = 0
        for (a in nums) {
            sum = (sum + a) % k
            if (sum < 0) sum += k // Because -1 % 5 = -1, but we need the positive mod 4
            count += map[sum]
            map[sum]++
        }
        return count
    }
}

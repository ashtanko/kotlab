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
 * 1829. Maximum XOR for Each Query
 * @link https://leetcode.com/problems/maximum-xor-for-each-query/
 */
interface MaximumXor {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray
}

class MaximumXorOnePass : MaximumXor {
    override fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val n = nums.size
        val res = IntArray(n)
        var value = (1 shl maximumBit) - 1
        for (i in nums.indices) {
            value = value xor nums[i]
            res[n - i - 1] = value
        }
        return res
    }
}

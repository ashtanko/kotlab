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

import java.util.Random

/**
 * 169. Majority Element
 * @see <a href="https://leetcode.com/problems/majority-element">Source</a>
 */
fun interface MajorityElement {
    operator fun invoke(nums: IntArray): Int
}

class MajorityElementHashTable : MajorityElement {
    override fun invoke(nums: IntArray): Int {
        val counter = HashMap<Int, Int>()

        for (num in nums) {
            val count = counter.getOrDefault(num, 0) + 1
            counter[num] = count

            if (count > nums.size / 2) {
                return num
            }
        }

        return 0
    }
}

class MajorityElementSorting : MajorityElement {
    override fun invoke(nums: IntArray) = nums.takeIf { it.isNotEmpty() }?.sorted()?.get(nums.size / 2) ?: 0
}

class MajorityElementRandomization : MajorityElement {
    override fun invoke(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0
        val random = Random()
        var candidate: Int
        var counter: Int

        while (true) {
            candidate = nums[random.nextInt(n)]
            counter = 0

            for (num in nums) {
                if (num == candidate) {
                    counter++
                }
            }

            if (counter > n / 2) {
                return candidate
            }
        }
    }
}

class MajorityElementDivideAndConquer : MajorityElement {
    override fun invoke(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        return majority(nums.toList(), 0, nums.size - 1)
    }

    private fun majority(nums: List<Int>, l: Int, r: Int): Int {
        if (l == r) {
            return nums[l]
        }

        val m = l + (r - l) / 2
        val lm = majority(nums, l, m)
        val rm = majority(nums, m + 1, r)

        if (lm == rm) {
            return lm
        }

        val countLm = nums.subList(l, r + 1).count { it == lm }
        val countRm = nums.subList(l, r + 1).count { it == rm }

        return if (countLm > countRm) lm else rm
    }
}

class MajorityElementBit : MajorityElement {

    companion object {
        private const val POSITIONS = 32
    }

    override fun invoke(nums: IntArray): Int {
        var majority = 0

        for (i in 0 until POSITIONS) {
            var bits = 0

            for (num in nums) {
                if (num and (1 shl i) != 0) {
                    bits++
                }
            }

            if (bits > nums.size / 2) {
                majority = majority or (1 shl i)
            }
        }

        return majority
    }
}

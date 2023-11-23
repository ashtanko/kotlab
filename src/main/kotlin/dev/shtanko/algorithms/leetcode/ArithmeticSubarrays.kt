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
import kotlin.math.min

/**
 * 1630. Arithmetic Subarrays
 * @see <a href="https://leetcode.com/problems/arithmetic-subarrays">Source</a>
 */
fun interface ArithmeticSubarrays {
    operator fun invoke(nums: IntArray, l: IntArray, r: IntArray): List<Boolean>
}

class ArithmeticSubarraysSort : ArithmeticSubarrays {
    override fun invoke(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val ans: MutableList<Boolean> = ArrayList()
        for (i in l.indices) {
            val arr = IntArray(r[i] - l[i] + 1)
            for (j in arr.indices) {
                arr[j] = nums[l[i] + j]
            }
            ans.add(check(arr))
        }

        return ans
    }

    private fun check(arr: IntArray): Boolean {
        arr.sort()
        val diff = arr[1] - arr[0]
        for (i in 2 until arr.size) {
            if (arr[i] - arr[i - 1] != diff) {
                return false
            }
        }
        return true
    }
}

class ArithmeticSubarraysSet : ArithmeticSubarrays {
    override fun invoke(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val ans: MutableList<Boolean> = ArrayList()
        for (i in l.indices) {
            val arr = IntArray(r[i] - l[i] + 1)
            for (j in arr.indices) {
                arr[j] = nums[l[i] + j]
            }
            ans.add(check(arr))
        }

        return ans
    }

    private fun check(arr: IntArray): Boolean {
        var minElement = Int.MAX_VALUE
        var maxElement = Int.MIN_VALUE
        val arrSet: MutableSet<Int> = HashSet()
        for (num in arr) {
            minElement = min(minElement, num)
            maxElement = max(maxElement, num)
            arrSet.add(num)
        }
        if ((maxElement - minElement) % (arr.size - 1) != 0) {
            return false
        }
        val diff = (maxElement - minElement) / (arr.size - 1)
        var curr = minElement + diff
        while (curr < maxElement) {
            if (!arrSet.contains(curr)) {
                return false
            }
            curr += diff
        }
        return true
    }
}

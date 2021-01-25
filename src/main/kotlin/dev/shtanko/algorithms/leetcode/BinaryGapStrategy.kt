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

private const val MAX_SIZE = 32

/**
 * 868. Binary Gap
 * @link https://leetcode.com/problems/binary-gap/
 */
interface BinaryGapStrategy {
    fun binaryGap(n: Int): Int
}

/**
 * Approach 1: Store Indexes
 * Time Complexity: O(log N).
 * Space Complexity: O(log N).
 */
class BGStoreIndexes : BinaryGapStrategy {

    override fun binaryGap(n: Int): Int {
        val a = IntArray(MAX_SIZE)
        var t = 0
        for (i in 0 until MAX_SIZE) if (n shr i and 1 != 0) a[t++] = i
        var ans = 0
        for (i in 0 until t - 1) ans = ans.coerceAtLeast(a[i + 1] - a[i])
        return ans
    }
}

/**
 * Approach 2: One Pass
 * Time Complexity: O(log N).
 * Space Complexity: O(1).
 */
class BGOnePass : BinaryGapStrategy {
    override fun binaryGap(n: Int): Int {
        var last = -1
        var ans = 0
        for (i in 0 until MAX_SIZE) if (n shr i and 1 > 0) {
            if (last >= 0) ans = ans.coerceAtLeast(i - last)
            last = i
        }

        return ans
    }
}

class BGOther : BinaryGapStrategy {
    override fun binaryGap(n: Int): Int {
        var max = 0
        var pos = 0
        var lastPos = -1
        var changed = n
        while (changed != 0) {
            pos++
            if (changed and 1 == 1) {
                if (lastPos != -1) {
                    max = max.coerceAtLeast(pos - lastPos)
                }
                lastPos = pos
            }
            changed = changed shr 1
        }
        return max
    }
}

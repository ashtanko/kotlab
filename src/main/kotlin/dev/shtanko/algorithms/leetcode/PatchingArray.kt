/*
 * Copyright 2022 Alexey Shtanko
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
 * 330. Patching Array
 * @link https://leetcode.com/problems/patching-array/
 */
interface PatchingArray {
    fun minPatches(nums: IntArray, n: Int): Int
}

class PatchingArraySimple : PatchingArray {
    override fun minPatches(nums: IntArray, n: Int): Int {
        var miss: Long = 1
        var added = 0
        var i = 0
        while (miss <= n) {
            if (i < nums.size && nums[i] <= miss) {
                miss += nums[i++]
            } else {
                miss += miss
                added++
            }
        }
        return added
    }
}

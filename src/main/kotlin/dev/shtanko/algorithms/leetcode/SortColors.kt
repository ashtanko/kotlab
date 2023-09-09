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

private const val RED = 0
private const val WHITE = 1
private const val BLUE = 2

fun interface SortColorsStrategy {
    operator fun invoke(nums: IntArray)
}

class SortColorsOnePass : SortColorsStrategy {
    override operator fun invoke(nums: IntArray) {
        var p1 = 0
        var p2 = nums.size - 1
        var index = 0
        while (index <= p2) {
            if (nums[index] == RED) {
                nums[index] = nums[p1]
                nums[p1] = RED
                p1++
            }
            if (nums[index] == BLUE) {
                nums[index] = nums[p2]
                nums[p2] = BLUE
                p2--
                index--
            }
            index++
        }
    }
}

class SortColorsTwoPass : SortColorsStrategy {
    override operator fun invoke(nums: IntArray) {
        var red = 0
        var white = 0
        var blue = 0
        for (num in nums) {
            when (num) {
                RED -> red++
                WHITE -> white++
                BLUE -> blue++
            }
        }
        for (i in nums.indices) {
            when {
                i < red -> nums[i] = RED
                i < red + white -> nums[i] = WHITE
                else -> nums[i] = BLUE
            }
        }
    }
}

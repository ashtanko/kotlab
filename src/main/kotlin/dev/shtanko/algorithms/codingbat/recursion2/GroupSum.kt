/*
 * Copyright 2024 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.codingbat.recursion2

import java.util.Stack

/**
 * Recursion-2 > groupSum
 * @see <a href="https://codingbat.com/prob/p145416">Source</a>
 */
fun interface GroupSum {
    operator fun invoke(start: Int, nums: IntArray, target: Int): Boolean
}

class GroupSumIterable : GroupSum {
    override fun invoke(start: Int, nums: IntArray, target: Int): Boolean {
        val stack = Stack<Triple<Int, Int, Int>>() // (start, target, index)
        stack.push(Triple(start, target, 0))

        while (stack.isNotEmpty()) {
            val (currStart, currTarget, currIndex) = stack.pop()

            if (currStart >= nums.size) {
                if (currTarget == 0) {
                    return true
                }
                continue
            }

            // Include current element
            stack.push(Triple(currStart + 1, currTarget - nums[currStart], currIndex + 1))

            // Exclude current element
            stack.push(Triple(currStart + 1, currTarget, currIndex + 1))
        }

        return false
    }
}

class GroupSumBacktracking : GroupSum {
    override fun invoke(start: Int, nums: IntArray, target: Int): Boolean {
        if (start >= nums.size) {
            return target == 0
        }

        if (invoke(start + 1, nums, target - nums[start])) {
            return true
        }
        if (invoke(start + 1, nums, target)) {
            return true
        }
        return false
    }
}

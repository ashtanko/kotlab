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

import java.util.Stack

/**
 * 907. Sum of Subarray Minimums
 * @see <a href="https://leetcode.com/problems/sum-of-subarray-minimums/">leetcode page</a>
 */
interface SumSubarrayMins {
    operator fun invoke(arr: IntArray): Int
}

/**
 * Approach 2: Monotonic Stack + Dynamic Programming
 */
class SumSubarrayMinsDP : SumSubarrayMins {

    override operator fun invoke(arr: IntArray): Int {
        val stack: Stack<Int> = Stack()

        // make a dp array of the same size as the input array `arr`
        val dp = IntArray(arr.size)

        // making a monotonic increasing stack
        for (i in arr.indices) {
            // pop the stack until it is empty or
            // the top of the stack is greater than or equal to
            // the current element
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop()
            }

            // either the previousSmaller element exists
            if (stack.size > 0) {
                val previousSmaller: Int = stack.peek()
                dp[i] = dp[previousSmaller] + (i - previousSmaller) * arr[i]
            } else {
                // or it doesn't exist, in this case the current element
                // contributes with all subarrays ending at i
                dp[i] = (i + 1) * arr[i]
            }
            // push the current index
            stack.push(i)
        }

        // Add all elements of the dp to get the answer
        var sumOfMinimums: Long = 0
        for (count in dp) {
            sumOfMinimums += count.toLong()
            sumOfMinimums %= MOD.toLong()
        }
        return sumOfMinimums.toInt()
    }
}

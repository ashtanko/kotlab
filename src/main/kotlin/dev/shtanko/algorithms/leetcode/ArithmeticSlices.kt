/*
 * Copyright 2021 Oleksii Shtanko
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

package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.annotations.BruteForce
import dev.shtanko.algorithms.annotations.BruteForceOptimized
import dev.shtanko.algorithms.annotations.DP
import dev.shtanko.algorithms.annotations.Math
import dev.shtanko.algorithms.annotations.Recursive
import dev.shtanko.algorithms.complexity.RuntimeComplexity
import dev.shtanko.algorithms.complexity.SpaceComplexity

/**
 * Arithmetic Slices
 * @see <a href="https://leetcode.com/problems/arithmetic-slices/">Source</a>
 */
fun interface ArithmeticSlices {
    operator fun invoke(arr: IntArray): Int
}

/**
 * Approach 1: Brute Force
 * Time complexity : O(n^3).
 * Space complexity : O(1).
 */
@RuntimeComplexity(short = "O(n^3)")
@SpaceComplexity(short = "O(1)")
@BruteForce
class ArSlicesBruteForce : ArithmeticSlices {
    override fun invoke(arr: IntArray): Int {
        var count = 0
        for (s in 0 until arr.size - 2) {
            val d: Int = arr[s + 1] - arr[s]
            for (e in s + 2 until arr.size) {
                var i: Int = s + 1
                while (i <= e) {
                    if (arr[i] - arr[i - 1] != d) break
                    i++
                }
                if (i > e) count++
            }
        }
        return count
    }
}

/**
 * Approach 2: Better Brute Force
 * Time complexity : O(n^2).
 * Space complexity : O(1).
 */
@RuntimeComplexity(short = "O(n^2)")
@SpaceComplexity(short = "O(1)")
@BruteForceOptimized
class ArSlicesBetterBruteForce : ArithmeticSlices {
    override fun invoke(arr: IntArray): Int {
        var count = 0
        for (s in 0 until arr.size - 2) {
            val d: Int = arr[s + 1] - arr[s]
            for (e in s + 2 until arr.size) {
                if (arr[e] - arr[e - 1] == d) count++ else break
            }
        }
        return count
    }
}

/**
 * Approach 3: Using Recursion
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
@Recursive
class ArSlicesRecursion : ArithmeticSlices {

    private var sum = 0

    override fun invoke(arr: IntArray): Int {
        slices(arr, arr.size - 1)
        return sum
    }

    private fun slices(arr: IntArray, i: Int): Int {
        if (i < 2) return 0
        var ap = 0
        if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
            ap = 1 + slices(arr, i - 1)
            sum += ap
        } else {
            slices(arr, i - 1)
        }
        return ap
    }
}

/**
 * Approach 4: Dynamic Programming
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
@DP
class ArSlicesDP : ArithmeticSlices {
    override fun invoke(arr: IntArray): Int {
        val dp = IntArray(arr.size)
        var sum = 0
        for (i in 2 until dp.size) {
            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
                dp[i] = 1 + dp[i - 1]
                sum += dp[i]
            }
        }
        return sum
    }
}

/**
 * Approach 5: Constant Space Dynamic Programming
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
@DP("Constant Space DP")
class ArSlicesConstantSpaceDP : ArithmeticSlices {
    override fun invoke(arr: IntArray): Int {
        var dp = 0
        var sum = 0
        for (i in 2 until arr.size) {
            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
                dp += 1
                sum += dp
            } else {
                dp = 0
            }
        }
        return sum
    }
}

/**
 * Approach 6: Using Formula
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
@Math
class ArSlicesFormula : ArithmeticSlices {
    override fun invoke(arr: IntArray): Int {
        var count = 0
        var sum = 0
        for (i in 2 until arr.size) {
            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
                count++
            } else {
                sum += (count + 1) * count / 2
                count = 0
            }
        }
        return count * (count + 1) / 2.let { sum += it; sum }
    }
}

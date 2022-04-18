/*
 * Copyright 2021 Oleksii Shtanko
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
 * 96. Unique Binary Search Trees
 * @link https://leetcode.com/problems/unique-binary-search-trees/
 */
interface UniqueBinarySearchTrees {
    fun numTrees(n: Int): Int
}

/**
 * Approach 1: Dynamic Programming
 * Time complexity O(N^2)
 * Space complexity O(N)
 */
class UniqueBSTDP : UniqueBinarySearchTrees {
    override fun numTrees(n: Int): Int {
        val g = IntArray(n + 1)
        g[0] = 1
        g[1] = 1

        for (i in 2..n) {
            for (j in 1..i) {
                g[i] += g[j - 1] * g[i - j]
            }
        }
        return g[n]
    }
}

/**
 * Approach 2: Mathematical Deduction
 * Time complexity : O(N)
 * Space complexity : O(1)
 */
class UniqueBSTDeduction : UniqueBinarySearchTrees {
    override fun numTrees(n: Int): Int {
        // Note: we should use long here instead of int, otherwise overflow
        var c: Long = 1
        for (i in 0 until n) {
            c = c * 2 * (2 * i + 1) / (i + 2)
        }
        return c.toInt()
    }
}

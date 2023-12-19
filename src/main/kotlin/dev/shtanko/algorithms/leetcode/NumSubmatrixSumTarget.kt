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

/**
 * 1074. Number of Submatrices That Sum to Target
 * @see <a href="https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/">Source</a>
 */
fun interface NumSubmatrixSumTarget {
    operator fun invoke(matrix: Array<IntArray>, target: Int): Int
}

/**
 * Approach 1: Number of Subarrays that Sum to Target: Horizontal 1D Prefix Sum
 * Time complexity: O(R^2 C)
 * Space complexity: O(RC)
 */
class HorizontalPrefixSum : NumSubmatrixSumTarget {
    override operator fun invoke(matrix: Array<IntArray>, target: Int): Int {
        val r: Int = matrix.size
        val c: Int = matrix[0].size

        // compute 2D prefix sum
        val ps = Array(r + 1) { IntArray(c + 1) }
        for (i in 1 until r + 1) {
            for (j in 1 until c + 1) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + matrix[i - 1][j - 1]
            }
        }

        var count = 0
        var currSum: Int
        val h: MutableMap<Int, Int> = HashMap()
        // reduce 2D problem to 1D one
        // by fixing two rows r1 and r2 and
        // computing 1D prefix sum for all matrices using [r1..r2] rows
        for (r1 in 1 until r + 1) {
            for (r2 in r1 until r + 1) {
                h.clear()
                h[0] = 1
                for (col in 1 until c + 1) {
                    // current 1D prefix sum
                    currSum = ps[r2][col] - ps[r1 - 1][col]

                    // add subarrays which sum up to (currSum - target)
                    count += h.getOrDefault(currSum - target, 0)

                    // save current prefix sum
                    h[currSum] = h.getOrDefault(currSum, 0) + 1
                }
            }
        }

        return count
    }
}

/**
 * Approach 2: Number of Subarrays that Sum to Target: Vertical 1D Prefix Sum
 * Time complexity: O(RC^2)
 * Space complexity: O(RC)
 */
class VerticalPrefixSum : NumSubmatrixSumTarget {
    override operator fun invoke(matrix: Array<IntArray>, target: Int): Int {
        val r: Int = matrix.size
        val c: Int = matrix[0].size

        // compute 2D prefix sum
        val ps = Array(r + 1) { IntArray(c + 1) }
        for (i in 1 until r + 1) {
            for (j in 1 until c + 1) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + matrix[i - 1][j - 1]
            }
        }

        var count = 0
        var currSum: Int
        val h: MutableMap<Int, Int> = HashMap()
        // reduce 2D problem to 1D one
        // by fixing two columns c1 and c2 and
        // computing 1D prefix sum for all matrices using [c1..c2] columns
        for (c1 in 1 until c + 1) {
            for (c2 in c1 until c + 1) {
                h.clear()
                h[0] = 1
                for (row in 1 until r + 1) {
                    // current 1D prefix sum
                    currSum = ps[row][c2] - ps[row][c1 - 1]

                    // add subarrays which sum up to (currSum - target)
                    count += h.getOrDefault(currSum - target, 0)

                    // save current prefix sum
                    h[currSum] = h.getOrDefault(currSum, 0) + 1
                }
            }
        }

        return count
    }
}

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

import kotlin.math.max

interface IsSubsequence {
    fun perform(source: String, target: String): Boolean
}

class IsSubsequenceDP : IsSubsequence {
    override fun perform(source: String, target: String): Boolean {
        val rows: Int = source.length
        val cols: Int = target.length
        // the source string is empty
        if (rows == 0) return true

        val matrix = Array(rows + 1) { IntArray(cols + 1) }
        // DP calculation, we fill the matrix column by column, bottom up
        for (col in 1..cols) {
            for (row in 1..rows) {
                // find another match
                if (source[row - 1] == target[col - 1]) {
                    matrix[row][col] =
                        matrix[row - 1][col - 1] + 1
                } else {
                    // retrieve the maximal result from previous prefixes
                    matrix[row][col] = max(matrix[row][col - 1], matrix[row - 1][col])
                }
            }
            // check if we can consume the entire source string,
            // with the current prefix of the target string.
            if (matrix[rows][col] == rows) return true
        }
        // matching failure
        return false
    }
}

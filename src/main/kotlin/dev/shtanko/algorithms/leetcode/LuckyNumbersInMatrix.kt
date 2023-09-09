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

fun interface AbstractLuckyNumbersStrategy {
    operator fun invoke(matrix: Array<IntArray>): List<Int>
}

class LuckyNumbers : AbstractLuckyNumbersStrategy {
    override operator fun invoke(matrix: Array<IntArray>): List<Int> {
        val m = matrix.size
        val n = matrix[0].size
        val mi = IntArray(m) { Integer.MAX_VALUE }
        val mx = IntArray(n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                mi[i] = matrix[i][j].coerceAtMost(mi[i])
                mx[j] = matrix[i][j].coerceAtLeast(mx[j])
            }
        }
        val res: MutableList<Int> = ArrayList()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mi[i] == mx[j]) {
                    res.add(mi[i])
                }
            }
        }

        return res
    }
}

class LuckyNumbersSet : AbstractLuckyNumbersStrategy {
    override operator fun invoke(matrix: Array<IntArray>): List<Int> {
        val minSet: MutableSet<Int> = HashSet()
        val maxSet: MutableSet<Int> = HashSet()

        for (row in matrix) {
            var mi = row[0]
            for (cell in row) {
                mi = mi.coerceAtMost(cell)
            }
            minSet.add(mi)
        }

        for (j in matrix[0].indices) {
            var mx = matrix[0][j]
            for (i in matrix.indices) {
                mx = matrix[i][j].coerceAtLeast(mx)
            }
            if (minSet.contains(mx)) {
                maxSet.add(mx)
            }
        }

        return maxSet.toList()
    }
}

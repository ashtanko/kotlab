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

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
fun Array<IntArray>.spiralOrder(): List<Int> {
    val res: MutableList<Int> = ArrayList()
    if (this.isEmpty()) {
        return res
    }
    var rowBegin = 0
    var rowEnd = this.size - 1
    var colBegin = 0
    var colEnd: Int = this[0].size - 1
    while (rowBegin <= rowEnd && colBegin <= colEnd) {
        // Traverse Right
        for (j in colBegin..colEnd) {
            res.add(this[rowBegin][j])
        }
        rowBegin++

        // Traverse Down
        for (j in rowBegin..rowEnd) {
            res.add(this[j][colEnd])
        }
        colEnd--
        if (rowBegin <= rowEnd) {
            // Traverse Left
            for (j in colEnd downTo colBegin) {
                res.add(this[rowEnd][j])
            }
        }
        rowEnd--
        if (colBegin <= colEnd) {
            // Traver Up
            for (j in rowEnd downTo rowBegin) {
                res.add(this[j][colBegin])
            }
        }
        colBegin++
    }
    return res
}

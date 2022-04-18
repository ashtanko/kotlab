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

fun Pair<Array<IntArray>, Int>.kWeakestRows(): IntArray {
    val matrix = first
    val rows = matrix.size
    val cols = matrix.first().size
    val score = IntArray(rows)
    var j: Int
    for (i in 0 until rows) {
        j = 0
        while (j < cols) {
            if (matrix[i][j] == 0) {
                break
            }
            j++
        }
        score[i] = j * rows + i
    }
    score.sort()
    for (i in score.indices) {
        score[i] = score[i] % rows
    }
    return score.copyOfRange(0, second)
}

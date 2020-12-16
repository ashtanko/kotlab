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

private const val FOUR = 4 // todo rename
private const val TWO = 2 // todo rename

fun Array<IntArray>.islandPerimeter(): Int {
    var islands = 0
    var neighbours = 0
    for (i in indices) {
        for (j in this[i].indices) {
            if (this[i][j] == 1) {
                islands++
                // count down neighbours
                if (i < this.size - 1 && this[i + 1][j] == 1) {
                    neighbours++
                }
                // count right neighbours
                if (j < this[i].size - 1 && this[i][j + 1] == 1) {
                    neighbours++
                }
            }
        }
    }
    return islands * FOUR - neighbours * TWO
}

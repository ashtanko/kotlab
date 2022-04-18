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

fun Int.pascalsTriangle(): List<List<Int>> {
    val triangle: MutableList<MutableList<Int>> = ArrayList()
    if (this <= 0) {
        return triangle
    }
    for (i in 0 until this) {
        val row: MutableList<Int> = ArrayList()
        for (j in 0 until i + 1) {
            if (j == 0 || j == i) {
                row.add(1)
            } else {
                row.add(triangle[i - 1][j - 1] + triangle[i - 1][j])
            }
        }
        triangle.add(row)
    }
    return triangle
}

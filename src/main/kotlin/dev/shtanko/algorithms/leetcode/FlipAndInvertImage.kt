/*
 * Copyright 2020 Oleksii Shtanko
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

fun flipAndInvertImage(arr: Array<IntArray>): Array<IntArray> {
    val c: Int = arr[0].size
    for (row in arr) for (i in 0 until (c + 1) / 2) {
        val tmp = row[i] xor 1
        row[i] = row[c - 1 - i] xor 1
        row[c - 1 - i] = tmp
    }

    return arr
}

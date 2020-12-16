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

private const val MAX_SUB_ARRAY_SIZE = 2

fun IntArray.numTeams(): Int {
    var res = 0
    for (i in 1 until size - 1) {
        val less = IntArray(MAX_SUB_ARRAY_SIZE)
        val greater = IntArray(MAX_SUB_ARRAY_SIZE)
        for (j in 0 until size) {
            if (this[i] < this[j]) {
                ++less[if (j > i) 1 else 0]
            }
            if (this[i] > this[j]) {
                ++greater[if (j > i) 1 else 0]
            }
        }
        res += less[0] * greater[1] + greater[0] * less[1]
    }
    return res
}

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

import kotlin.math.abs

fun Array<IntArray>.minTimeToVisitAllPoints(): Int {
    var ans = 0
    for (i in 1 until size) {
        val prev = this[i - 1]
        val cur = this[i]
        ans += abs(cur[0] - prev[0]).coerceAtLeast(abs(cur[1] - prev[1]))
    }
    return ans
}

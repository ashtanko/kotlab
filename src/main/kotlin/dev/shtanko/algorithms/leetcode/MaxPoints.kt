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

import dev.shtanko.algorithms.math.gcd

private const val SAME_LINE = 3

fun Array<IntArray>.maxPoints(): Int {
    if (size < SAME_LINE) return size
    var maxRes = 0
    for (i in indices) {
        var same = 0
        var tempMax = 0
        val map = HashMap<String, Int>()
        for (j in indices) {
            if (i != j) {
                val dx = this[i][0] - this[j][0]
                val dy = this[i][1] - this[j][1]
                if (dx == 0 && dy == 0) {
                    same++
                    continue
                }
                val gcd = (dx to dy).gcd()
                val key = dx.div(gcd).toString().plus("/").plus(dy / gcd)
                map[key] = map.getOrDefault(key, 0).plus(1)
                tempMax = tempMax.coerceAtLeast(map[key]!!)
            }
        }
        maxRes = maxRes.coerceAtLeast(tempMax + same + 1)
    }
    return maxRes
}

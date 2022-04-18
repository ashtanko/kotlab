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

import java.util.ArrayList
import java.util.TreeMap

fun IntArray.arrayRankTransform(): IntArray {
    val map: MutableMap<Int, MutableList<Int>> =
        TreeMap()
    for (i in indices) {
        val current = map.getOrDefault(this[i], ArrayList())
        current.add(i)
        map[this[i]] = current
    }
    var rank = 1
    for ((_, currentList) in map) {
        for (i in currentList) this[i] = rank
        rank++
    }
    return this
}

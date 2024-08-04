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

import java.util.TreeMap

/**
 * Assigns ranks to elements in the array. Elements with the same value will have the same rank.
 *
 * @return IntArray with ranks assigned to elements.
 */
fun IntArray.arrayRankTransform(): IntArray {
    // Using TreeMap to automatically sort elements and keep track of their indices
    val map: MutableMap<Int, MutableList<Int>> = TreeMap()

    // Populate the map with indices for each unique element
    for (i in indices) {
        val current = map.getOrDefault(this[i], mutableListOf())
        current.add(i)
        map[this[i]] = current
    }

    // Assign ranks to elements in the array
    var rank = 1
    for ((_, currentList) in map) {
        for (i in currentList) {
            this[i] = rank
        }
        rank++
    }

    return this
}

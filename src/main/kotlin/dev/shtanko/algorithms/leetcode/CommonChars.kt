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
 * Find Common Characters
 */
fun Array<String>.commonChars(): List<String> {
    val map1: MutableMap<Char, Int?> = HashMap()
    val map2: MutableMap<Char, Int?> = HashMap()
    val arr = ArrayList<Char>()
    if (isEmpty()) return emptyList()
    for (i in this.first().toCharArray()) { // get the frequency of the string to use to compare against
        if (map1.containsKey(i)) map1[i] = map1[i]?.plus(1) else map1[i] = 1
    }
    for (h in 1 until this.size) {
        for (i in this[h].toCharArray()) { // get the frequencies of the next string
            if (map2.containsKey(i)) map2[i] = map2[i]?.plus(1) else map2[i] = 1
        }
        for (i in map2.keys) if (map1.containsKey(i)) {
            val x = map2[i]?.coerceAtMost(map1[i]!!) // find the intersection between two pairs of strings
            map1[i] = x
        }
        for (i in map1.keys) {
            if (!map2.containsKey(i)) {
                arr.add(i)
            }
        } // temporarily store the char rather than delete right away to avoid concurrent modification
        for (t in arr) map1.remove(t) // remove whatever was not contained in the next string
        map2.clear() // clear the map
    }
    val array = ArrayList<String>()
    for (k in map1.keys) { // make the required list
        for (i in 0 until map1[k]!!) {
            array.add(k.toString())
        }
    }
    return array
}

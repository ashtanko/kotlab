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
 * Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 */
fun Pair<String, String>.isIsomorphic(): Boolean {
    if (first.length <= 1) return true
    val map = hashMapOf<Char, Char>()
    for (i in first.indices) {
        val a = first[i]
        val b = second[i]

        if (map.containsKey(a)) {
            if (map[a] == b) {
                continue
            } else {
                return false
            }
        } else {
            if (!map.containsValue(b)) {
                map[a] = b
            } else {
                return false
            }
        }
    }
    return true
}

/*
 * Copyright 2022 Oleksii Shtanko
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
 * 2053. Kth Distinct String in an Array
 * link https://leetcode.com/problems/kth-distinct-string-in-an-array/
 */
fun interface KTHDistinct {
    operator fun invoke(arr: Array<String>, k: Int): String
}

class KTHDistinctImpl : KTHDistinct {
    override operator fun invoke(arr: Array<String>, k: Int): String {
        val map: MutableMap<String, Boolean> = HashMap()
        var k0 = k
        for (s in arr) {
            map[s] = !map.containsKey(s)
        }
        for (s in arr) {
            if (map[s]!! && k0-- == 1) return s
        }
        return ""
    }
}

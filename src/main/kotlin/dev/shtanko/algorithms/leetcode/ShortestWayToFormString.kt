/*
 * Copyright 2021 Oleksii Shtanko
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

object ShortestWayToFormString {
    fun twoPointers(source: String, target: String): Int {
        var t = 0
        var ans = 0
        while (t < target.length) {
            val pt = t
            for (s in source.indices) {
                if (t < target.length && source[s] == target[t]) {
                    t++
                }
            }

            if (t == pt) {
                return -1
            }
            ans++
        }
        return ans
    }
}

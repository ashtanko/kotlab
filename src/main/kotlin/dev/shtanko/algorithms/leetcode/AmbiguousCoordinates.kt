/*
 * Copyright 2021 Oleksii Shtanko
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

class AmbiguousCoordinates {
    operator fun invoke(s: String): List<String> {
        val ans: MutableList<String> = ArrayList()
        for (i in 2 until s.length - 1) {
            for (left in make(s, 1, i)) {
                for (right in make(s, i, s.length - 1)) {
                    ans.add("($left, $right)")
                }
            }
        }
        return ans
    }

    fun make(s: String, i: Int, j: Int): List<String?> {
        val ans: MutableList<String?> = ArrayList()
        for (d in 1..j - i) {
            val left = s.substring(i, i + d)
            val right = s.substring(i + d, j)
            if ((!left.startsWith("0") || left == "0") && !right.endsWith("0")) {
                ans.add(left + (if (d < j - i) "." else "") + right)
            }
        }
        return ans
    }
}

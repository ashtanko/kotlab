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

/**
 * Multiply Strings.
 * @see <a href="https://leetcode.com/problems/multiply-strings/">leetcode page</a>
 */
object MultiplyStrings {
    fun perform(num1: String, num2: String): String {
        val m: Int = num1.length
        val n: Int = num2.length
        val pos = IntArray(m + n)

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                val mul: Int = (num1[i] - '0') * (num2[j] - '0')
                val p1 = i + j
                val p2 = i + j + 1
                val sum = mul + pos[p2]
                pos[p1] += sum / DECIMAL
                pos[p2] = sum % DECIMAL
            }
        }

        val sb = StringBuilder()
        for (p in pos) if (!(sb.isEmpty() && p == 0)) sb.append(p)
        return if (sb.isEmpty()) "0" else sb.toString()
    }
}

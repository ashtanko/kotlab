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

fun String.atoi(): Int {
    if (this.isEmpty()) return 0 // or throw NumberFormatException()
    val str = this.trim()
    if (str.isEmpty()) return 0 // or throw NumberFormatException()
    var start = 0
    var sign = 1
    var base = 0
    if (str[start] == '-' || str[start] == '+') {
        sign = if (str[start] == '-') -1 else 1
        start++
    }

    while (start < str.length && str[start] in '0'..'9') {
        val a = base == Int.MAX_VALUE / DECIMAL && str[start] - '0' > Int.MAX_VALUE % DECIMAL
        if (base > Int.MAX_VALUE / DECIMAL || a) {
            return if (sign > 0) {
                Int.MAX_VALUE
            } else {
                Int.MIN_VALUE
            }
        }
        base = base * DECIMAL + (str[start++] - '0')
    }

    return base * sign
}

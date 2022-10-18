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

import kotlin.math.abs

fun String.mirroring(): String {
    val x = this.substring(0, length / 2)
    return x + (if (length % 2 == 1) this[length / 2] else "") + StringBuilder(x).reverse().toString()
}

@Throws(NumberFormatException::class)
fun String.nearestPalindromic(): String {
    if (this.isEmpty()) return ""
    if (this == "1") return "0"
    val a = this.mirroring()
    var diff1: Long
    diff1 = abs(this.toLong() - a.toLong())
    if (diff1 == 0L) diff1 = Long.MAX_VALUE
    var s = StringBuilder(this)
    var i = (s.length - 1) / 2
    while (i >= 0 && s[i] == '0') {
        s.replace(i, i + 1, "9")
        i--
    }
    if (i == 0 && s[i] == '1') {
        s.delete(0, 1)
        val mid = (s.length - 1) / 2
        s.replace(mid, mid + 1, "9")
    } else {
        s.replace(i, i + 1, "" + (s[i].code - 1).toChar())
    }
    val b = s.toString().mirroring()
    val diff2 = abs(this.toLong() - b.toLong())
    s = StringBuilder(this)
    i = (s.length - 1) / 2
    while (i >= 0 && s[i] == '9') {
        s.replace(i, i + 1, "0")
        i--
    }
    if (i < 0) {
        s.insert(0, "1")
    } else {
        s.replace(i, i + 1, "" + (s[i].code + 1).toChar())
    }
    val c = s.toString().mirroring()
    val diff3 = abs(this.toLong() - c.toLong())
    if (diff2 <= diff1 && diff2 <= diff3) {
        return b
    }
    return if (diff1 <= diff3 && diff1 <= diff2) {
        a
    } else {
        c
    }
}

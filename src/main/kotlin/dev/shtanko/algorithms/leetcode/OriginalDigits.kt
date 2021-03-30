/*
 * Copyright 2021 Alexey Shtanko
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

private const val COUNT_ARRAY_SIZE = 26
private const val OUT_ARRAY_SIZE = 10

fun originalDigits(s: String): String {
    val count = CharArray(COUNT_ARRAY_SIZE + 'a'.toInt())
    for (letter in s.toCharArray()) {
        count[letter.toInt()]++
    }
    val out = IntArray(OUT_ARRAY_SIZE)
    out[0] = count['z'.toInt()].toInt()
    out[2] = count['w'.toInt()].toInt()
    out[4] = count['u'.toInt()].toInt()
    out[6] = count['x'.toInt()].toInt()
    out[8] = count['g'.toInt()].toInt()
    out[3] = (count['h'.toInt()] - out[8]).toInt()
    out[5] = (count['f'.toInt()] - out[4]).toInt()
    out[7] = (count['s'.toInt()] - out[6]).toInt()
    out[9] = (count['i'.toInt()] - out[5] - out[6] - out[8]).toInt()
    out[1] = (count['n'.toInt()] - out[7] - 2 * out[9]).toInt()

    // building output string

    // building output string
    val output = StringBuilder()
    for (i in 0..9) for (j in 0 until out[i]) output.append(i)
    return output.toString()
}

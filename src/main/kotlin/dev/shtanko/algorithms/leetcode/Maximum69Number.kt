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

import kotlin.math.pow

private const val FIRST_SIX = 6
private const val CD = 3
private const val MOD = 10.0

fun maximum69Number(num: Int): Int {
    var firstSix = -1
    var number: Int = num
    var i = 0
    while (number > 0) {
        if (number % DECIMAL == FIRST_SIX) {
            firstSix = i
        }
        number /= DECIMAL
        i++
    }
    return num + CD * MOD.pow(firstSix.toDouble()).toInt()
}

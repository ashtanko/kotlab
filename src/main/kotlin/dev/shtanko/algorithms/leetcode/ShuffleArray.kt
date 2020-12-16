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

/**
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 */
fun IntArray.shuffle(n: Int): IntArray {
    for (i in n until 2 * n) {
        this[i] = this[i] shl HEXADECIMAL
        this[i] = this[i] or this[i - n]
    }
    var i = 0
    while (i < 2 * n) {
        this[i] = this[n + i / 2] and SHUFFLE_CONST
        this[i + 1] = this[n + i / 2] shr HEXADECIMAL
        i += 2
    }
    return this
}

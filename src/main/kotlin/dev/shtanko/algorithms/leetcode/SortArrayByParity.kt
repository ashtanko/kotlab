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

import dev.shtanko.algorithms.extensions.isEven
import dev.shtanko.algorithms.extensions.swap

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 */
fun IntArray.sortArrayByParity(): IntArray {
    var i = 0
    var j = size - 1
    while (i < j) {
        if (this[i].isEven) {
            i++
        } else {
            if (!this[j].isEven) {
                j--
            }
            if (this[j].isEven) {
                swap(i, j)
                i++
                j--
            }
        }
    }
    return this
}

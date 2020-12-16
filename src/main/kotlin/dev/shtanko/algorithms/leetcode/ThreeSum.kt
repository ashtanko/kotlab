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

import java.util.LinkedList

fun IntArray.threeSum(): List<List<Int>> {
    sort()

    val result: MutableList<List<Int>> = LinkedList()
    for (i in 0 until this.size - 2) {
        val local = i > 0 && this[i] != this[i - 1]
        if (i == 0 || local) {
            var lo = i + 1
            var hi = this.size - 1
            val sum = 0 - this[i]

            while (lo < hi) {
                when {
                    this[lo] + this[hi] == sum -> {
                        result.add(listOf(this[i], this[lo], this[hi]))
                        while (lo < hi && this[lo] == this[lo + 1]) lo++
                        while (lo < hi && this[hi] == this[hi - 1]) hi--
                        lo++
                        hi--
                    }
                    this[lo] + this[hi] < sum -> {
                        lo++
                    }
                    else -> {
                        hi--
                    }
                }
            }
        }
    }
    return result
}

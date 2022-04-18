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

import dev.shtanko.algorithms.extensions.swap

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 */
interface AbstractSortByParityStrategy {
    fun perform(array: IntArray): IntArray
}

class SortByParityTwoPass : AbstractSortByParityStrategy {
    override fun perform(array: IntArray): IntArray {
        val n = array.size
        val ans = IntArray(n)
        var t = 0
        for (x in array) {
            if (x % 2 == 0) {
                ans[t] = x
                t += 2
            }
        }
        t = 1
        for (x in array) {
            if (x % 2 == 1) {
                ans[t] = x
                t += 2
            }
        }
        return ans
    }
}

class SortByParityHeads : AbstractSortByParityStrategy {
    override fun perform(array: IntArray): IntArray {
        var j = 1
        var i = 0
        while (i < array.size) {
            if (array[i] % 2 == 1) {
                while (array[j] % 2 == 1) {
                    j += 2
                }
                array.swap(i, j)
            }
            i += 2
        }
        return array
    }
}

class SortByParityStraightForward : AbstractSortByParityStrategy {
    override fun perform(array: IntArray): IntArray {
        val n = array.size
        var e = 0
        var o = 1
        while (e < n && o < n) {
            if (array[e] % 2 != 0) {
                array.swap(e, o)
                o += 2
            } else {
                e += 2
            }
        }
        return array
    }
}

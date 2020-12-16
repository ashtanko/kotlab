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
 * Given an unsorted integer array, find the smallest missing positive integer.
 */
fun IntArray.firstMissingPositive(): Int {
    val n = this.size
    if (n == 0) return 1
    for (i in 0 until n) {
        var current = this[i]
        while (current - 1 in 0 until n && current != this[current - 1]) {
            val next = this[current - 1]
            this[current - 1] = current
            current = next
        }
    }
    for (i in 0 until n) {
        if (this[i] != i + 1) {
            return i + 1
        }
    }
    return n + 1
}

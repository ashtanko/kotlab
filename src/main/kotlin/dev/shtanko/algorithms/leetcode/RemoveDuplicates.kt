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

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once
 * and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place
 * with O(1) extra memory.
 */
fun IntArray.removeDuplicates(): Int {
    val n = this.size
    if (n < 2) return n
    var count = 0
    for (i in 1 until n) {
        if (this[i] == this[i - 1]) {
            count++
        } else {
            this[i - count] = this[i]
        }
    }
    return n - count
}

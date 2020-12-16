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
 * Given an array of size n, find the majority element. The majority element is the element that appears
 * more than ⌊ n/2 ⌋ times.
 */
fun IntArray.majorityElement(): Int {
    var major = this[0]

    var count = 1
    for (i in 1 until size) {
        when {
            count == 0 -> {
                count++
                major = this[i]
            }
            major == this[i] -> {
                count++
            }
            else -> {
                count--
            }
        }
    }

    return major
}

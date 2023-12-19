/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

private const val ARR_MAX_SIZE = 101

fun IntArray.heightChecker(): Int {
    val heightToFreq = IntArray(ARR_MAX_SIZE)
    for (height in this) {
        heightToFreq[height]++
    }
    var result = 0
    var curHeight = 0
    for (i in indices) {
        while (heightToFreq[curHeight] == 0) {
            curHeight++
        }
        if (curHeight != this[i]) {
            result++
        }
        heightToFreq[curHeight]--
    }
    return result
}

fun IntArray.heightCheckerSort(): Int {
    var count = 0
    val copy = this.clone()
    copy.sort()
    for (i in copy.indices) {
        if (this[i] != copy[i]) {
            count++
        }
    }
    return count
}

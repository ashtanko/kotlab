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

fun IntArray.searchInsertPosition(target: Int): Int {
    var low = 0
    var high = this.size - 1
    while (low <= high) {
        val mid = (low + high) / 2
        when {
            this[mid] == target -> {
                return mid
            }

            this[mid] > target -> {
                high = mid - 1
            }

            else -> {
                low = mid + 1
            }
        }
    }
    return low
}

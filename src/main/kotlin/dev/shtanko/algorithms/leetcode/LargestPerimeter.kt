/*
 * Copyright 2021 Oleksii Shtanko
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
 * 976. Largest Perimeter Triangle
 * @see <a href="https://leetcode.com/problems/largest-perimeter-triangle/">Source</a>
 */
fun largestPerimeter(arr: IntArray): Int {
    if (arr.isEmpty()) return 0
    arr.sort()
    for (i in arr.size - 3 downTo 0) {
        val sum = arr[i].plus(arr[i + 1])
        if (sum > arr[i + 2]) {
            return sum.plus(arr[i + 2])
        }
    }
    return 0
}

/*
 * Copyright 2021 Alexey Shtanko
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
 * 1700. Number of Students Unable to Eat Lunch
 * @link https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 */
fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    val a = intArrayOf(0, 0)
    for (element in students) a[element] += 1
    var k = 0
    while (k < sandwiches.size) {
        if (a[sandwiches[k]] > 0) a[sandwiches[k]] -= 1 else break
        k += 1
    }
    return sandwiches.size - k
}

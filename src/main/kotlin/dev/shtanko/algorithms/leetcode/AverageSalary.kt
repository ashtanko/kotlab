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
 * Given an array of unique integers salary where salary[i] is the salary of the employee i.
 */
fun IntArray.averageSalary(): Double {
    var sum = 0.0
    var min = Int.MAX_VALUE
    var max = 0
    for (salary in this) {
        sum += salary
        if (salary < min) {
            min = salary
        }
        if (salary > max) {
            max = salary
        }
    }
    return sum.minus(max).minus(min) / size.minus(2)
}

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

fun sumEvenAfterQueries(a: IntArray, queries: Array<IntArray>): IntArray {
    var s = 0
    for (x in a) if (x % 2 == 0) s += x

    val ans = IntArray(queries.size)

    for (i in queries.indices) {
        val value = queries[i][0]
        val index = queries[i][1]
        if (a[index] % 2 == 0) s -= a[index]
        a[index] += value
        if (a[index] % 2 == 0) s += a[index]
        ans[i] = s
    }

    return ans
}

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

import java.util.Deque
import java.util.LinkedList

fun shortestSubarray(a: IntArray, k: Int): Int {
    val n = a.size
    val p = LongArray(n + 1)
    for (i in 0 until n) p[i + 1] = p[i] + a[i].toLong()

    var ans = n + 1
    val monoq: Deque<Int> = LinkedList() // opt(y) candidates, as indices of P
    for (y in p.indices) {
        // Want opt(y) = largest x with P[x] <= P[y] - K;
        while (monoq.isNotEmpty() && p[y] <= p[monoq.last]) {
            monoq.removeLast()
        }
        while (monoq.isNotEmpty() && p[y] >= p[monoq.first] + k) {
            ans = ans.coerceAtMost(y - monoq.removeFirst())
        }
        monoq.addLast(y)
    }
    return if (ans < n + 1) ans else -1
}

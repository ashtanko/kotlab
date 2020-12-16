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

import java.util.TreeMap

private const val MAX_ARRAY_SIZE = 1001

fun Pair<IntArray, IntArray>.relativeSortArray(): IntArray {
    val cnt = IntArray(MAX_ARRAY_SIZE)
    for (n in first) {
        cnt[n]++
    }
    var i = 0
    for (n in second) {
        while (cnt[n]-- > 0) {
            first[i++] = n
        }
    }
    for (n in cnt.indices) {
        while (cnt[n]-- > 0) {
            first[i++] = n
        }
    }
    return first
}

fun Pair<IntArray, IntArray>.relativeSortArrayTree(): IntArray {
    val tree = TreeMap<Int, Int>()
    for (n in first) {
        tree[n] = tree.getOrDefault(n, 0) + 1
    }
    var i = 0
    for (n in second) {
        for (j in 0 until tree[n]!!) {
            first[i++] = n
        }
        tree.remove(n)
    }
    for (n in tree.keys) {
        for (j in 0 until tree[n]!!) {
            first[i++] = n
        }
    }
    return first
}

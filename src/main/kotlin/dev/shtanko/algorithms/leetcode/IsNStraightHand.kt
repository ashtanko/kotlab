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

import java.util.TreeMap

/**
 * Hand Of Straights
 */
fun isNStraightHand(hand: IntArray, w: Int): Boolean {
    val count: TreeMap<Int, Int?> = TreeMap()
    for (card in hand) {
        if (!count.containsKey(card)) count[card] = 1 else count.replace(card, count[card]!! + 1)
    }

    while (count.isNotEmpty()) {
        val first = count.firstKey()
        for (card in first until first + w) {
            if (!count.containsKey(card)) return false
            val c = count[card]!!
            if (c == 1) count.remove(card) else count.replace(card, c - 1)
        }
    }

    return true
}

package dev.shtanko.algorithms.leetcode

import java.util.TreeMap

fun isNStraightHand(hand: IntArray, w: Int): Boolean {

    val count: TreeMap<Int, Int?> = TreeMap()
    for (card in hand) {
        if (!count.containsKey(card)) count[card] = 1 else count.replace(card, count[card]!! + 1)
    }

    while (count.size > 0) {
        val first = count.firstKey()
        for (card in first until first + w) {
            if (!count.containsKey(card)) return false
            val c = count[card]!!
            if (c == 1) count.remove(card) else count.replace(card, c - 1)
        }
    }

    return true
}

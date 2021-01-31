package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.extensions.isEven

/**
 * 1523. Count Odd Numbers in an Interval Range
 * @link https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 */
object CountOdds {
    fun perform(low: Int, high: Int): Int {
        var count = high.minus(low).div(2)
        if (low.isEven.not() || high.isEven.not()) {
            count++
        }
        return count
    }
}

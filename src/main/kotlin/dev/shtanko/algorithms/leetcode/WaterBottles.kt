package dev.shtanko.algorithms.leetcode

/**
 * Water Bottles.
 * Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.
 * The operation of drinking a full water bottle turns it into an empty bottle.
 * Return the maximum number of water bottles you can drink.
 * @link https://leetcode.com/problems/water-bottles/
 */
class WaterBottles {
    fun perform(numBottles: Int, numExchange: Int): Int {
        if (numExchange == 0) return numBottles
        var nBottles = numBottles
        var ans = nBottles
        while (nBottles >= numExchange) {
            val remainder = nBottles % numExchange
            nBottles /= numExchange
            ans += nBottles
            nBottles += remainder
        }
        return ans
    }
}

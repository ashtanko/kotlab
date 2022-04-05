package dev.shtanko.algorithms.leetcode

import kotlin.math.min

/**
 * 638. Shopping Offers
 * @link https://leetcode.com/problems/shopping-offers/
 */
interface ShoppingOffers {
    fun perform(price: List<Int>, special: List<List<Int>>, needs: List<Int>): Int
}

class ShoppingOffersRecursive : ShoppingOffers {
    override fun perform(price: List<Int>, special: List<List<Int>>, needs: List<Int>): Int {
        return backTrace(price, special, needs, 0)
    }

    private fun backTrace(price: List<Int>, special: List<List<Int>>, needs: List<Int>, start: Int): Int {
        var res = directPurchase(price, needs)
        for (i in start until special.size) {
            val offer = special[i]
            if (isValid(offer, needs)) { // offer is a valid one
                val tempNeeds: MutableList<Int> = ArrayList()
                for (j in needs.indices) { // using this valid offer
                    tempNeeds.add(needs[j] - offer[j])
                }
                res = min(res, offer[offer.size - 1] + backTrace(price, special, tempNeeds, start))
            }
        }
        return res
    }

    private fun isValid(offer: List<Int>, needs: List<Int>): Boolean {
        for (i in needs.indices) {
            if (needs[i] < offer[i]) return false
        }
        return true
    }

    private fun directPurchase(price: List<Int>, needs: List<Int>): Int {
        var total = 0
        for (i in needs.indices) {
            total += price[i] * needs[i]
        }
        return total
    }
}

package dev.shtanko.algorithms.leetcode

class LemonadeChange {

    fun perform(bills: IntArray): Boolean {
        var five = 0
        var ten = 0
        for (i in bills) {
            when {
                i == BILL_FIVE -> five++
                i == BILL_TEN -> {
                    five--
                    ten++
                }
                ten > 0 -> {
                    ten--
                    five--
                }
                else -> five -= BILL_THREE
            }
            if (five < 0) return false
        }
        return true
    }

    companion object {
        private const val BILL_FIVE = 5
        private const val BILL_THREE = 3
        private const val BILL_TEN = 10
    }
}

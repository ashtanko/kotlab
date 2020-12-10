package dev.shtanko.algorithms.leetcode

private const val MAX = 9

interface AddDigitsStrategy {
    fun perform(digits: Int): Int
}

class AddDigitsStraightForward : AddDigitsStrategy {
    override fun perform(digits: Int): Int {
        var digitalRoot = 0
        var num = digits
        while (num > 0) {
            digitalRoot += num % DECIMAL
            num /= DECIMAL
            if (num == 0 && digitalRoot > MAX) {
                num = digitalRoot
                digitalRoot = 0
            }
        }
        return digitalRoot
    }
}

class AddDigitsMath : AddDigitsStrategy {
    override fun perform(digits: Int): Int {
        if (digits == 0) return 0
        if (digits % MAX == 0) return MAX
        return digits % MAX
    }
}

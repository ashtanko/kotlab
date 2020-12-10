package dev.shtanko.algorithms.leetcode

class PlusOne {

    fun perform(digits: IntArray): IntArray {
        val carry = 1
        for (i in digits.size - 1 downTo 0) {
            digits[i] += carry
            if (digits[i] <= MAX_DIGIT_RESTRICTION) {
                return digits
            }
            digits[i] = 0
        }
        val ret = IntArray(digits.size + 1)
        ret[0] = 1
        return ret
    }

    companion object {
        private const val MAX_DIGIT_RESTRICTION = 9
    }
}

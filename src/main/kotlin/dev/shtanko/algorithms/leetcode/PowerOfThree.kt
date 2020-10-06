package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.PowerOfThreeStrategy.Companion.POWER
import kotlin.math.log10

interface PowerOfThreeStrategy {
    companion object {
        const val POWER = 3
    }

    fun isPowerOfThree(n: Int): Boolean
}

class POTLoopIteration : PowerOfThreeStrategy {

    override fun isPowerOfThree(n: Int): Boolean {
        var num = n
        if (num < 1) {
            return false
        }

        while (num % POWER == 0) {
            num /= POWER
        }

        return num == 1
    }
}

class POTBaseConversion : PowerOfThreeStrategy {
    override fun isPowerOfThree(n: Int): Boolean {
        return n.toString(POWER).matches("^10*$".toRegex())
    }
}

class POTMathematics : PowerOfThreeStrategy {
    override fun isPowerOfThree(n: Int): Boolean {
        val local = log10(n.toDouble()) / log10(POWER.toDouble())

        return local % 1.0 == 0.0
    }
}

class POTIntegerLimitations : PowerOfThreeStrategy {

    companion object {
        private const val LIMIT = 1162261467
    }

    override fun isPowerOfThree(n: Int): Boolean {
        return n > 0 && LIMIT % n == 0
    }
}

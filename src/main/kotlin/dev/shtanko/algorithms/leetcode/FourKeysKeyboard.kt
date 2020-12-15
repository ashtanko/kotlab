package dev.shtanko.algorithms.leetcode

import kotlin.math.max

/**
 *  4 Keys Keyboard.
 *  @link https://leetcode.com/problems/4-keys-keyboard/
 */
interface FourKeysKeyboard {
    fun maxA(n: Int): Int
}

/**
 * Approach #1: Dynamic Programming.
 */
class FourKeysKeyboardDP : FourKeysKeyboard {
    override fun maxA(n: Int): Int {
        val best = IntArray(n + 1)
        for (k in 1..n) {
            best[k] = best[k - 1] + 1
            for (x in 0 until k - 1) best[k] = max(best[k], best[x] * (k - x - 1))
        }
        return best[n]
    }
}

/**
 * Approach #3: Mathematical.
 */
class FourKeysKeyboardMath : FourKeysKeyboard {
    override fun maxA(n: Int): Int {
        val q = if (n > MAX) (n - N_MAX) / MULTIPLY_LIMIT else 0
        return best[n - MULTIPLY_LIMIT * q] shl 2 * q
    }

    companion object {
        private val best = intArrayOf(
            0, 1, 2, 3, 4, 5, 6, 9, 12,
            16, 20, 27, 36, 48, 64, 81
        )
        private const val MAX = 15
        private const val N_MAX = 11
        private const val MULTIPLY_LIMIT = 5
    }
}

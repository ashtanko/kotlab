package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import kotlin.math.ln

/**
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * @link https://leetcode.com/problems/power-of-four/
 */
interface PowOfFour {
    fun isPow4(n: Int): Boolean
}

/**
 *  Approach 1: Brute Force + Precomputations
 *  Time complexity: O(1).
 *  Space complexity: O(1).
 */
class Pow4BruteForce : PowOfFour {

    private val n = 15
    private val nums: MutableList<Int> = ArrayList()

    init {
        var lastNum = 1
        nums.add(lastNum)
        for (i in 1 until n + 1) {
            lastNum *= 4
            nums.add(lastNum)
        }
    }

    override fun isPow4(n: Int): Boolean {
        return nums.contains(n)
    }
}

/**
 *  Approach 2: Math
 *  Time complexity: O(1).
 *  Space complexity: O(1).
 */
class Pow4Math : PowOfFour {
    override fun isPow4(n: Int): Boolean {
        return n > 0 && ln(n.toDouble()) / ln(2.0) % 2 == 0.0
    }
}

/**
 *  Approach 2: Math
 *  Time complexity: O(1).
 *  Space complexity: O(1).
 */
class Pow4BitManipulation : PowOfFour {
    override fun isPow4(n: Int): Boolean {
        return n > 0 && n and n - 1 == 0 && n and -0x55555556 == 0
    }
}

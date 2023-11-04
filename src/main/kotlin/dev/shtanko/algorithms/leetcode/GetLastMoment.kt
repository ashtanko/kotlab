package dev.shtanko.algorithms.leetcode

import kotlin.math.max

/**
 * 1503. Last Moment Before All Ants Fall Out of a Plank
 * @see <a href="https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank">Source</a>
 */
fun interface GetLastMoment {
    operator fun invoke(n: Int, left: IntArray, right: IntArray): Int
}

class GetLastMomentSolution : GetLastMoment {
    override fun invoke(n: Int, left: IntArray, right: IntArray): Int {
        var ans = 0
        for (num in left) {
            ans = max(ans.toDouble(), num.toDouble()).toInt()
        }

        for (num in right) {
            ans = max(ans, n - num)
        }

        return ans
    }
}

package dev.shtanko.algorithms.leetcode

/**
 * 1759. Count Number of Homogenous Substrings
 * @see <a href="https://leetcode.com/problems/count-number-of-homogenous-substrings">Source</a>
 */
fun interface CountHomogenous {
    operator fun invoke(s: String): Int
}

/**
 * Approach: Counting Streaks
 */
class CountHomogenousCountingStreaks : CountHomogenous {
    override fun invoke(s: String): Int {
        var ans = 0
        var currStreak = 0

        for (i in s.indices) {
            if (i == 0 || s[i] == s[i - 1]) {
                currStreak++
            } else {
                currStreak = 1
            }
            ans = (ans + currStreak) % MOD
        }

        return ans
    }
}

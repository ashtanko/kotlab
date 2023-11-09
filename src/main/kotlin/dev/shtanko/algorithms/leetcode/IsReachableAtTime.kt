package dev.shtanko.algorithms.leetcode

import kotlin.math.abs
import kotlin.math.max

/**
 * 2849. Determine if a Cell Is Reachable at a Given Time
 * @see <a href="https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time">Source</a>
 */
fun interface IsReachableAtTime {
    operator fun invoke(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean
}

class IsReachableAtTimeMath : IsReachableAtTime {
    override fun invoke(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val width = abs(sx - fx)
        val height = abs(sy - fy)
        return if (width == 0 && height == 0 && t == 1) {
            false
        } else t >= max(width.toDouble(), height.toDouble())
    }
}

package dev.shtanko.algorithms.leetcode

import java.math.BigInteger
import java.util.HashMap

private const val SAME_LINE = 3

/**
 * To avoid the precision issue with float/double numbers, using a pair of co-prime numbers to
 * represent the slope.
 */
private fun slopeCoprime(x1: Int, y1: Int, x2: Int, y2: Int): Pair<Int, Int> {
    var deltaX = x1 - x2
    var deltaY = y1 - y2
    when {
        deltaX == 0 -> return Pair(
            0,
            0
        )
        deltaY == 0 -> return Pair(
            Int.MAX_VALUE,
            Int.MAX_VALUE
        )
        deltaX < 0 -> {
            deltaX = -deltaX
            deltaY = -deltaY
        }
    }
    val gcd: Int =
        BigInteger.valueOf(deltaX.toLong()).gcd(BigInteger.valueOf(deltaY.toLong())).toInt()
    return Pair(deltaX / gcd, deltaY / gcd)
}

fun Array<IntArray>.addLine(
    i: Int,
    j: Int,
    c: Int,
    d: Int,
    lines: HashMap<Pair<Int, Int>, Int>
): Pair<Int, Int> {
    /*
     * Add a line passing through i and j points. Update max number of points on a line
     * containing point i. Update a number of duplicates of i point.
     */
    // rewrite points as coordinates
    var horizontalLines = 1
    var count = c
    var duplicates = d
    val x1 = this[i][0]
    val y1 = this[i][1]
    val x2 = this[j][0]
    val y2 = this[j][1]
    // add a duplicate point
    if (x1 == x2 && y1 == y2) duplicates++ else if (y1 == y2) {
        horizontalLines += 1
        count = horizontalLines.coerceAtLeast(count)
    } else {
        val slope = slopeCoprime(x1, y1, x2, y2)
        lines[slope] = lines.getOrDefault(slope, 1) + 1
        count = lines[slope]!!.coerceAtLeast(count)
    }
    return Pair(count, duplicates)
}

private fun Array<IntArray>.maxPointsOnALineContainingPointI(
    i: Int,
    lines: HashMap<Pair<Int, Int>, Int>,
    n: Int
): Int {
    /*
     * Compute the max number of points for a line containing point i.
     */
    // init lines passing through point i
    lines.clear()
    // One starts with just one point on a line : point i.
    var count = 1
    // There is no duplicates of a point i so far.
    var duplicates = 0

    // Compute lines passing through point i (fixed)
    // and point j.
    // Update in a loop the number of points on a line
    // and the number of duplicates of point i.
    for (j in i + 1 until n) {
        val p = addLine(i, j, count, duplicates, lines)
        count = p.first
        duplicates = p.second
    }
    return count + duplicates
}

fun Array<IntArray>.maxPoints(): Int {
    // If the number of points is less than 3
    // they are all on the same line.
    val n = size
    if (n < SAME_LINE) return n
    var maxCount = 1
    val lines = HashMap<Pair<Int, Int>, Int>()
    // Compute in a loop a max number of points
    // on a line containing point i.
    for (i in 0 until n - 1) {
        maxCount = maxPointsOnALineContainingPointI(i, lines, n).coerceAtLeast(maxCount)
    }
    return maxCount
}

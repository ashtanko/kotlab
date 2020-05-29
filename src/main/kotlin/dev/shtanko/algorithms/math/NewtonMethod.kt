package dev.shtanko.algorithms.math

import kotlin.math.abs

private const val EPSILON = 1e-15

/**
 * Compute the square root using Newton's method
 */
fun sqrt(c: Int, e: Double = EPSILON): Double {
    return sqrt(c.toDouble(), e)
}

fun sqrt(c: Double, e: Double = EPSILON): Double {
    if (c < 0) return Double.NaN
    var t = c
    while (abs(t - c / t) > e * t)
        t = (c / t + t) / 2.0
    return t
}

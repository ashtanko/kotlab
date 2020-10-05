package dev.shtanko.algorithms.leetcode

import kotlin.math.pow

private const val FIRST_SIX = 6
private const val CD = 3
private const val MOD = 10.0

fun maximum69Number(num: Int): Int {
    var firstSix = -1
    var number: Int = num
    var i = 0
    while (number > 0) {
        if (number % DECIMAL == FIRST_SIX) {
            firstSix = i
        }
        number /= DECIMAL
        i++
    }
    return num + CD * MOD.pow(firstSix.toDouble()).toInt()
}

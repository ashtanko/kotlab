package dev.shtanko.algorithms.math

/**
 * Greatest common divisor
 */
fun Pair<Int, Int>.gcd(): Int {
    var a = first
    var b = second
    while (b != 0) {
        val temp = a % b
        a = b
        b = temp
    }
    return a
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

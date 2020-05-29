package dev.shtanko.algorithms.math

/**
 * Binomial Coefficient
 * A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.
 * A binomial coefficient C(n, k) also gives the number of ways, disregarding order,
 * that k objects can be chosen from among n objects; more formally, the number of k-element subsets
 * (or k-combinations) of an n-element set.
 */
fun binomial(n: Int, k: Int): Long {
    var j = n - k + 1
    var binomial = 1L
    for (i in 1 until k + 1) {
        binomial = binomial * j / i
        j++
    }
    return binomial
}

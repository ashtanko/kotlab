package dev.shtanko.algorithms.leetcode

fun Int.divisorGame(): Boolean {
    return this % 2 == 0
}

fun Int.divisorGameNaive(): Boolean {
    return this and 1 == 0
}

fun Int.divisorGameBruteForce(): Boolean {
    for (x in 1 until this) {
        if (this % x == 0 && !(this - x).divisorGame()) {
            // if Bob fails, Alice wins
            return true
        }
    }
    return false
}

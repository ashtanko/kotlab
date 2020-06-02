package dev.shtanko.algorithms.math

fun Int.toFibonacciSequence(): Int {
    if (this <= 1) {
        return this
    }
    return (this - 1).toFibonacciSequence() + (this - 2).toFibonacciSequence()
}

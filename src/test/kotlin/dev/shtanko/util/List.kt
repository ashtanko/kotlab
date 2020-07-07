package dev.shtanko.util

fun <T : Comparable<T>> assertListEquals(expected: List<T>, actual: List<T>): Boolean {
    if (expected.size != actual.size) return false
    val expectedMutable = expected.toMutableList()
    val actualMutable = actual.toMutableList()
    expectedMutable.sort()
    actualMutable.sort()
    val ex2 = expectedMutable == actualMutable
    val ex1 = expectedMutable.removeAll(actual)
    return ex1 && ex2
}

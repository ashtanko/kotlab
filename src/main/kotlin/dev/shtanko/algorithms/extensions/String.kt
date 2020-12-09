package dev.shtanko.algorithms.extensions

/**
 * Check is a string binary.
 */
fun String.isBinary(): Boolean {
    if (this.isBlank()) return false
    val set = toSet().toMutableSet().apply {
        removeAll(listOf('0', '1'))
    }
    return set.isEmpty()
}

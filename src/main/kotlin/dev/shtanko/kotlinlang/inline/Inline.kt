package dev.shtanko.kotlinlang.inline

inline fun <T> Collection<T>.each(block: (T) -> Unit) {
    for (e in this) block(e)
}

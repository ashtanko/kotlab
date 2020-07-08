package dev.shtanko.algorithms.extensions

import kotlin.random.Random

fun ClosedRange<Char>.randomString(length: Int) =
    (1..length)
        .map { (Random.nextInt(endInclusive.toInt() - start.toInt()) + start.toInt()).toChar() }
        .joinToString("")

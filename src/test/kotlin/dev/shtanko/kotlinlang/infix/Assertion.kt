package dev.shtanko.kotlinlang.infix

import org.junit.jupiter.api.Assertions

class Assertion<T>(private val target: T) {
    infix fun isEqualTo(other: T) {
        Assertions.assertEquals(other, target)
    }

    infix fun isDifferentFrom(other: T) {
        Assertions.assertNotEquals(other, target)
    }
}

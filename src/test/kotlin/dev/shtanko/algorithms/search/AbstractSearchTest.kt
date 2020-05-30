package dev.shtanko.algorithms.search

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractSearchTest<out T : AbstractSearchStrategy<Int>>(private val strategy: T) {

    @Test
    fun `empty test`() {
        assertEquals(-1, strategy.perform(emptyArray(), 1))
    }
}
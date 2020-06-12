package dev.shtanko.algorithms.search

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

abstract class AbstractStringSearchTest<out T : AbstractSearchStrategy<String>>(private val strategy: T) {

    @Test
    fun `empty test`() {
        Assertions.assertEquals(-1, strategy.perform(emptyArray(), "A"))
    }

    @Test
    fun `single element test`() {
        val arr = arrayOf("A")
        Assertions.assertEquals(0, strategy.perform(arr, "A"))
        Assertions.assertEquals(-1, strategy.perform(arr, "B"))
    }

    @Test
    fun `two elements test`() {
        val arr = arrayOf("A", "B")
        Assertions.assertEquals(0, strategy.perform(arr, "A"))
        Assertions.assertEquals(1, strategy.perform(arr, "B"))
        Assertions.assertEquals(-1, strategy.perform(arr, "C"))
    }

    @Test
    fun `six elements test`() {
        val arr = arrayOf("A", "B", "C", "D", "E", "F")
        Assertions.assertEquals(0, strategy.perform(arr, "A"))
        Assertions.assertEquals(1, strategy.perform(arr, "B"))
        Assertions.assertEquals(2, strategy.perform(arr, "C"))
        Assertions.assertEquals(3, strategy.perform(arr, "D"))
        Assertions.assertEquals(4, strategy.perform(arr, "E"))
        Assertions.assertEquals(5, strategy.perform(arr, "F"))
        Assertions.assertEquals(-1, strategy.perform(arr, "G"))
    }
}

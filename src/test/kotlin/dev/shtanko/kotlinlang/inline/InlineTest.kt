package dev.shtanko.kotlinlang.inline

import org.junit.jupiter.api.Test

internal class InlineTest {

    @Test
    internal fun `each test`() {
        val list = listOf("A", "B", "C")
        list.each {
            println(it)
        }
    }
}

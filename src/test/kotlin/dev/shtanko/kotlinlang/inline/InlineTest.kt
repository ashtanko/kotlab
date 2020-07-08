package dev.shtanko.kotlinlang.inline

import org.junit.jupiter.api.Test

class InlineTest {

    @Test
    fun `each test`() {
        val list = listOf("A", "B", "C")
        list.each {
            println(it)
        }
    }
}

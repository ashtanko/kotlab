package dev.shtanko.algorithms.leetcode

import dev.shtanko.kotlinlang.inline.each
import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class HappyNumberTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(19, true),
            Arguments.of(16, false),
            Arguments.of(23, true)
        )
    }

    internal class InputListArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(0, listOf<Int>()),
            Arguments.of(5, listOf(1)),
            Arguments.of(25, listOf(1, 7, 10, 13, 19, 23)),
            Arguments.of(50, listOf(1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49)),
            Arguments.of(100, listOf(1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97))
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `happy number test`(n: Int, expected: Boolean) {
        val actual = n.isHappy()
        assertEquals(expected, actual)
    }

    @Test
    internal fun `lost list test`() {
        val happyList = mutableListOf<Int>()
        listOf(4, 8, 15, 16, 23, 42).each {
            if (it.isHappy()) {
                happyList.add(it)
            }
        }
        assertEquals(23, happyList.first())
    }

    @ParameterizedTest
    @ArgumentsSource(InputListArgumentsProvider::class)
    internal fun `happy number list test`(times: Int, expected: List<Int>) {
        val happyList = mutableListOf<Int>()
        repeat(times) {
            if (it.isHappy()) {
                happyList.add(it)
            }
        }
        assertEquals(expected, happyList)
    }
}

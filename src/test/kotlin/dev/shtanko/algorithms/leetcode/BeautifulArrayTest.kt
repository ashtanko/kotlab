package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class BeautifulArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                intArrayOf(1, 3, 2, 4)
            ),
            Arguments.of(
                5,
                intArrayOf(1, 5, 3, 2, 4)
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `beautiful array test`(n: Int, expected: IntArray) {
        val actual = BeautifulArray().perform(n)
        assertArrayEquals(expected, actual)
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `beautiful array divide and conquer test`(n: Int, expected: IntArray) {
        val actual = BeautifulArray().divideAndConquer(n)
        assertArrayEquals(expected, actual)
    }
}

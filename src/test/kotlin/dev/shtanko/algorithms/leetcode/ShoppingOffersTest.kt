package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class ShoppingOffersTest<out T : ShoppingOffers>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(2, 5),
                listOf(
                    listOf(3, 0, 5),
                    listOf(1, 2, 10)
                ),
                listOf(3, 2),
                14
            ),
            Arguments.of(
                listOf(2, 3, 4),
                listOf(
                    listOf(1, 1, 0, 4),
                    listOf(2, 2, 1, 9)
                ),
                listOf(1, 2, 1),
                11
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `shopping offers test`(price: List<Int>, special: List<List<Int>>, needs: List<Int>, expected: Int) {
        val actual = strategy.perform(price, special, needs)
        assertThat(actual).isEqualTo(expected)
    }
}

class ShoppingOffersRecursiveTest : ShoppingOffersTest<ShoppingOffers>(ShoppingOffersRecursive())

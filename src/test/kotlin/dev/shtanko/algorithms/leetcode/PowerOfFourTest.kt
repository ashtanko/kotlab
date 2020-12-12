package dev.shtanko.algorithms.leetcode

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class PowerOfFourTest<out T : PowOfFour>(private val strategy: T) {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(0, false),
            Arguments.of(1, true),
            Arguments.of(5, false),
            Arguments.of(16, true)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `power of four test`(n: Int, expected: Boolean) {
        val actual = strategy.isPow4(n)
        assertThat(actual, equalTo(expected))
    }
}

internal class Pow4BruteForceTest : PowerOfFourTest<Pow4BruteForce>(Pow4BruteForce())
internal class Pow4MathTest : PowerOfFourTest<Pow4Math>(Pow4Math())
internal class Pow4BitManipulationTest : PowerOfFourTest<Pow4BitManipulation>(Pow4BitManipulation())

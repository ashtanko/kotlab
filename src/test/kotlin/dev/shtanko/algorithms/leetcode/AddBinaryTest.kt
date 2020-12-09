package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class AddBinaryTest<out T : AddBinaryStrategy>(private val strategy: T) {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("11", "1", "100"),
            Arguments.of("1010", "1011", "10101"),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `simple test`(a: String, b: String, expected: String) {
        val actual = strategy.perform(a, b)
        assertEquals(expected, actual)
    }
}

internal class AddBinaryBitByBitComputationTest :
    AddBinaryTest<AddBinaryBitByBitComputation>(AddBinaryBitByBitComputation())

internal class AddBinaryBitManipulationTest :
    AddBinaryTest<AddBinaryBitManipulation>(AddBinaryBitManipulation())

package dev.shtanko.algorithms.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class ArithmeticSlicesTest<out T : ArithmeticSlices>(private val strategy: T) {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                3
            ),
            Arguments.of(
                intArrayOf(1, 2),
                0
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `number of arithmetic slices test`(arr: IntArray, expected: Int) {
        val actual = strategy.numberOfArithmeticSlices(arr)
        assertThat(actual).isEqualTo(expected)
    }
}

internal class ArSlicesBruteForceTest : ArithmeticSlicesTest<ArSlicesBruteForce>(ArSlicesBruteForce())
internal class ArSlicesBetterBruteForceTest : ArithmeticSlicesTest<ArSlicesBetterBruteForce>(ArSlicesBetterBruteForce())
internal class ArSlicesRecursionTest : ArithmeticSlicesTest<ArSlicesRecursion>(ArSlicesRecursion())
internal class ArSlicesDPTest : ArithmeticSlicesTest<ArSlicesDP>(ArSlicesDP())
internal class ArSlicesConstantSpaceDPTest : ArithmeticSlicesTest<ArSlicesConstantSpaceDP>(ArSlicesConstantSpaceDP())
internal class ArSlicesFormulaTest : ArithmeticSlicesTest<ArSlicesFormula>(ArSlicesFormula())

package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class ClimbingStairsTest<out T : ClimbingStairsStrategy>(private val strategy: T) {
    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 3),
            Arguments.of(4, 5),
            Arguments.of(5, 8),
            Arguments.of(6, 13),
            Arguments.of(7, 21),
            Arguments.of(8, 34),
            Arguments.of(9, 55),
            Arguments.of(10, 89),
            Arguments.of(20, 10946),
            Arguments.of(30, 1346269),
            Arguments.of(40, 165580141)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `climb stairs test`(n: Int, expected: Int) {
        val actual = strategy.perform(n)
        assertEquals(expected, actual)
    }
}

internal class ClimbingStairsBruteForceTest : ClimbingStairsTest<ClimbingStairsBruteForce>(ClimbingStairsBruteForce())
internal class ClimbingStairsRecursionMemoTest :
    ClimbingStairsTest<ClimbingStairsRecursionMemo>(ClimbingStairsRecursionMemo())

internal class ClimbingStairsDPTest : ClimbingStairsTest<ClimbingStairsDP>(ClimbingStairsDP())
internal class ClimbingStairsFibonacciTest : ClimbingStairsTest<ClimbingStairsFibonacci>(ClimbingStairsFibonacci())
internal class ClimbingStairsBinetsMethodTest :
    ClimbingStairsTest<ClimbingStairsBinetsMethod>(ClimbingStairsBinetsMethod())

internal class ClimbingStairsFibonacciFormulaTest :
    ClimbingStairsTest<ClimbingStairsFibonacciFormula>(ClimbingStairsFibonacciFormula())

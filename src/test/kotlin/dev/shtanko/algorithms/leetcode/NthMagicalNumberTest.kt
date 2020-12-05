package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal abstract class NthMagicalNumberTest<out T : NthMagicalNumberStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun numbersDataProvider(): Stream<Arguments?> = Stream.of(
            Arguments.of(1, 2, 3, 2),
            Arguments.of(4, 2, 3, 6),
            Arguments.of(5, 2, 4, 10),
            Arguments.of(3, 6, 4, 8)
        )
    }

    @ParameterizedTest
    @MethodSource("numbersDataProvider")
    internal fun `nth magical number test`(n: Int, a: Int, b: Int, expected: Int) {
        val actual = strategy.perform(n, a, b)
        assertEquals(expected, actual)
    }
}

internal class NthMagicalNumberMathTest : NthMagicalNumberTest<NthMagicalNumberMath>(NthMagicalNumberMath())

internal class NthMagicalNumberBSTest : NthMagicalNumberTest<NthMagicalNumberBS>(NthMagicalNumberBS())

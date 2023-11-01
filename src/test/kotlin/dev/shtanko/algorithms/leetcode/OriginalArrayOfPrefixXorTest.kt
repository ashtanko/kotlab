package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.OriginalArrayOfPrefixXorSolution.SpaceOptimized
import dev.shtanko.algorithms.leetcode.OriginalArrayOfPrefixXorSolution.XORProperties
import java.util.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class OriginalArrayOfPrefixXorTest<out T : OriginalArrayOfPrefixXor>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 2, 0, 3, 1),
                intArrayOf(5, 7, 2, 3, 2),
            ),
            Arguments.of(
                intArrayOf(13),
                intArrayOf(13),
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `find array test`(pref: IntArray, expected: IntArray) {
        val actual = strategy(pref)
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

class OriginalArrayOfPrefixXorPropertiesTest : OriginalArrayOfPrefixXorTest<OriginalArrayOfPrefixXor>(XORProperties)

class OriginalArrayOfPrefixXorSpaceOptimizedTest :
    OriginalArrayOfPrefixXorTest<OriginalArrayOfPrefixXor>(SpaceOptimized)

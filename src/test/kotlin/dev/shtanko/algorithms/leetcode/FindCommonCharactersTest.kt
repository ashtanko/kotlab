package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.extensions.randomString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FindCommonCharactersTest {

    companion object {

        private const val RANDOM_STRING_LENGTH = 6
        private const val RANDOM_ARRAY_SIZE = 100_000

        @JvmStatic
        private fun provideChars(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(arrayOf("bella", "label", "roller"), listOf("e", "l", "l")),
                Arguments.of(arrayOf("cool", "lock", "cook"), listOf("c", "o")),
                Arguments.of(arrayOf("a", "b", "c"), listOf<String>()),
                Arguments.of(arrayOf("far", "bar", "rar"), listOf("a", "r")),
                Arguments.of(
                    Array(RANDOM_ARRAY_SIZE) { ('a'..'z').randomString(RANDOM_STRING_LENGTH) + "q" },
                    listOf("q")
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideChars")
    fun `common chars test`(arr: Array<String>, expected: List<String>) {
        val actual = arr.commonChars()
        assertEquals(expected, actual)
    }
}

package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CountCharactersTest {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(arrayOf("cat", "bt", "hat", "tree"), "atach", 6),
                Arguments.of(arrayOf("hello", "world", "leetcode"), "welldonehoneyr", 10)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `simple test`(words: Array<String>, chars: String, expected: Int) {
        val actual = words.countCharacters(chars)
        assertEquals(expected, actual)
    }
}

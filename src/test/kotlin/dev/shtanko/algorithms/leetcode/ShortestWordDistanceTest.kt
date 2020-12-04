package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class ShortestWordDistanceTest<out T : ShortestWordDistanceStrategy>(private val strategy: T) {
    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("practice", "makes", "perfect", "coding", "makes"),
                "coding",
                "practice",
                3
            ),
            Arguments.of(
                arrayOf("practice", "makes", "perfect", "coding", "makes"),
                "makes",
                "coding",
                1
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `shortest distance test`(words: Array<String>, word1: String, word2: String, expected: Int) {
        val actual = strategy.perform(words, word1, word2)
        assertEquals(expected, actual)
    }
}

class ShortestWordDistanceBruteForceTest :
    ShortestWordDistanceTest<ShortestWordDistanceBruteForce>(ShortestWordDistanceBruteForce())

class ShortestWordDistanceOnePassTest :
    ShortestWordDistanceTest<ShortestWordDistanceOnePass>(ShortestWordDistanceOnePass())
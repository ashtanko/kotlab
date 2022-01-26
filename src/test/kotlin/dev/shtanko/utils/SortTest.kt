package dev.shtanko.utils

import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.ValueSource

class SortTest {

    private class MergeInputParamsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                getMetadata(intArrayOf(1, 3, 2)),
                intArrayOf(1, 2, 3),
            ),
            Arguments.of(
                getMetadata(intArrayOf(3, 2, 1)),
                intArrayOf(1, 3, 2),
            ),
            Arguments.of(
                getMetadata(intArrayOf(3, 2)),
                intArrayOf(2, 3),
            ),
            Arguments.of(
                getMetadata(intArrayOf(2, 3)),
                intArrayOf(2, 3),
            ),
            Arguments.of(
                getMetadata(intArrayOf(1)),
                intArrayOf(1),
            ),
            Arguments.of(
                getMetadata(intArrayOf(2, 2, 2)),
                intArrayOf(2, 2, 2),
            ),
        )

        private fun getMetadata(array: IntArray): Pair<IntArray, Triple<Int, Int, Int>> {
            val low = 0
            val high = array.size - 1
            val mid = low.plus(high).div(2)
            return array to Triple(low, mid, high)
        }
    }

    @ParameterizedTest
    @ArgumentsSource(MergeInputParamsProvider::class)
    fun `merge test`(data: Pair<IntArray, Triple<Int, Int, Int>>, expected: IntArray) {
        val array = data.first
        val (low, middle, high) = data.second
        val helper = IntArray(array.size)
        merge(array, helper, low, middle, high)
        assertThat(array).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 100, 1000, 10_000, 100_000])
    fun `new random array test`(n: Int) {
        val array = n.toRandomArray()
        assertThat(array.size).isEqualTo(n)
    }
}

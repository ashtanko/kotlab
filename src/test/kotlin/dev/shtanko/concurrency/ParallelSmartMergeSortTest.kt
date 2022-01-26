package dev.shtanko.concurrency

import dev.shtanko.algorithms.sorts.MergeSort
import dev.shtanko.utils.toRandomArray
import java.util.concurrent.ForkJoinPool
import java.util.stream.Stream
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.fail
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

class ParallelSmartMergeSortTest {

    private class ParallelInputArguments : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1000,
                7
            ),
            Arguments.of(
                10_000,
                7
            ),
            Arguments.of(
                100_000,
                10
            ),
        )
    }

    @Test
    fun `test sequential`() {
        val array = 1000.toRandomArray().toTypedArray()
        MergeSort().perform(array)
        check(array.toIntArray())
    }

    @ParameterizedTest
    @ArgumentsSource(ParallelInputArguments::class)
    fun `test parallel`(n: Int, parallelism: Int) {
        val array = n.toRandomArray()
        val forkJoinPool = ForkJoinPool(parallelism)
        forkJoinPool.invoke(ParallelSmartMergeSort(array, 0, array.size - 1))
    }

    private fun check(array: IntArray) {
        var last = Int.MIN_VALUE
        for (i in array.indices) {
            if (array[i] < last) {
                fail("Fail")
            }
            last = array[i]
        }
    }
}

package dev.shtanko.concurrency

import dev.shtanko.utils.toRandomArray
import java.util.Arrays
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Fork
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Warmup

open class ParallelSmartMergeSortBenchmarkRunner {

    companion object {
        private const val SIZE = 100_000

        @JvmStatic
        @Throws(Exception::class)
        fun main(args: Array<String>) {
            org.openjdk.jmh.Main.main(args)
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    fun benchParallelSmart() {
        val array = SIZE.toRandomArray()
        val forkJoinPool = ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1)
        forkJoinPool.invoke(ParallelSmartMergeSort(array, 0, array.size - 1))
        Arrays.parallelSort(array)
    }
}

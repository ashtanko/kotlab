package dev.shtanko.kotlinlang.collections

import com.carrotsearch.junitbenchmarks.AbstractBenchmark
import com.carrotsearch.junitbenchmarks.BenchmarkOptions
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart
import org.junit.jupiter.api.Test

@BenchmarkMethodChart(filePrefix = "benchmark-sample")
class SampleBenchmarkTest : AbstractBenchmark() {

    private val largeList = (0..1000)
    private val largeSequence = largeList.asSequence()

    @Test
    @BenchmarkOptions(benchmarkRounds = 3, warmupRounds = 0)
    fun `simple test`() {
        println("Hello")
    }
}

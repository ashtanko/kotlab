/*
 * Copyright 2020 Alexey Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.kotlinlang.collections

import com.carrotsearch.junitbenchmarks.AbstractBenchmark
import com.carrotsearch.junitbenchmarks.BenchmarkOptions
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart
import org.junit.jupiter.api.Test

@BenchmarkMethodChart(filePrefix = "benchmark-sample")
class SampleBenchmarkTest : AbstractBenchmark() {

    private val largeList = 0..1000
    private val largeSequence = largeList.asSequence()

    @Test
    @BenchmarkOptions(benchmarkRounds = 3, warmupRounds = 0)
    fun `simple test`() {
        println("Hello")
    }
}

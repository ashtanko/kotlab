/*
 * Copyright 2022 Oleksii Shtanko
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

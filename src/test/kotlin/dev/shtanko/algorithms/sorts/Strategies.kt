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

package dev.shtanko.algorithms.sorts

internal class SelectionSortTest : AbstractSortTest<SelectionSort>(SelectionSort())

internal class StableSelectionSortTest : AbstractSortTest<StableSelectionSort>(StableSelectionSort())

internal class ShellSortTest : AbstractSortTest<ShellSort>(ShellSort())

internal class QuickSortTest : AbstractSortTest<QuickSort>(QuickSort())

internal class MergeSortTest : AbstractSortTest<MergeSort>(MergeSort())

internal class InsertionSortTest : AbstractSortTest<InsertionSort>(InsertionSort())

internal class InsertionSort2Test : AbstractSortTest<InsertionSort2>(InsertionSort2())

internal class HeapSortTest : AbstractSortTest<HeapSort>(HeapSort())

internal class BubbleSortTest : AbstractSortTest<BubbleSort>(BubbleSort())

internal class SimpleBubbleSortTest : AbstractSortTest<SimpleBubbleSort>(SimpleBubbleSort())

internal class ArraySortTest : AbstractSortTest<ArraySort>(ArraySort())

internal class PancakeSortTest : AbstractSortTest<PancakeSort>(PancakeSort())

internal class GnomeSortTest : AbstractSortTest<GnomeSort>(GnomeSort())

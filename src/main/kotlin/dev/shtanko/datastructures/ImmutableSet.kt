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

package dev.shtanko.datastructures

import dev.shtanko.algorithms.search.BinarySearch

/**
 * The class represents set of comparables. The values are stored in a sorted array,
 * and the inclusion queries perform binary search, taking logarithmic time in the worst case.
 */
class ImmutableSet<T : Comparable<T>>(values: Array<T>) : Set<T> {

    private val arr: Array<T> = values.sortedArray()
    private val bs = BinarySearch<T>()

    override val size: Int
        get() = arr.size

    override fun contains(element: T): Boolean {
        return bs.perform(arr, element) != -1
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return elements.all {
            contains(it)
        }
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun iterator(): Iterator<T> {
        return arr.iterator()
    }
}

fun <T : Comparable<T>> immutableSetOf(vararg elements: T): ImmutableSet<out T> {
    return ImmutableSet(elements.copyOf())
}

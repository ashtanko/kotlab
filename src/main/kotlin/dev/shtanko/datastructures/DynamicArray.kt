/*
 * Copyright 2021 Oleksii Shtanko
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

class DynamicArray<T>(initialCapacity: Int) {
    private var data: Array<Any?>
    private var size: Int = 0
    private var initialCapacity: Int

    // Init over constructor
    init {
        data = arrayOfNulls(initialCapacity)
        this.initialCapacity = initialCapacity
    }

    fun get(index: Int): Any? = data[index]

    fun set(index: Int, value: T) {
        data[index] = value
        size++
    }

    fun insert(index: Int, value: T) {
        // Check size
        if (size == initialCapacity) {
            resize()
        }
        // Copy up | Shift
        for (i in size downTo index) {
            data[i + 1] = data[i]
        }

        // Insert
        data[index] = value
        size++
    }

    fun print() {
        data.forEach { println("data[i] = $it") }
    }

    fun add(value: T) {
        if (size == initialCapacity) {
            resize()
        }
        data[size] = value
        size++
    }

    fun delete(index: Int) {
        // Copy down
        for (i in index until size - 1) data[i] = data[i + 1]

        // Clear if last element in array
        if (index == size) data[index] = null else data[size - 1] = null

        size--
    }

    fun size() = size

    fun isEmpty() = size == 0

    fun contains(value: T): Boolean {
        data.forEach {
            if (it == value) return true
        }
        return false
    }

    private fun resize() {
        val newCapacity = if (initialCapacity == 0) 1 else initialCapacity * 2
        val newData = arrayOfNulls<Any?>(newCapacity)
        if (initialCapacity >= 0) System.arraycopy(data, 0, newData, 0, initialCapacity)
        // manual copy array
        /* for (int i = 0; i < initialCapacity; i++) {
            newData[i] = data[i];
        }*/
        data = newData
        initialCapacity = newCapacity
    }
}

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

import java.util.Arrays

private const val INT_MAP_CAPACITY = 10
private const val ARRAY_MAP_SIZE_INDEX = 4

@Suppress("UNCHECKED_CAST")
class IntMap<V> constructor(capacity: Int = INT_MAP_CAPACITY) {

    private var hashes: IntArray = IntArray(if (capacity < 0) 0 else capacity)
    private var array: Array<Any?> = arrayOfNulls(if (capacity < 0) 0 else capacity)

    private var size = 0

    fun isEmpty() = size <= 0

    operator fun get(key: Int) = get(key, null)

    fun get(key: Int, valueIfKeyNotFound: V?): V? {
        val index = Arrays.binarySearch(hashes, 0, size, key)
        return if (index < 0) valueIfKeyNotFound else array[index] as V
    }

    fun delete(key: Int) {
        val index = Arrays.binarySearch(hashes, 0, size, key)
        if (index >= 0) removeAt(index)
    }

    fun removeAt(index: Int) {
        System.arraycopy(hashes, index + 1, hashes, index, size - (index + 1))
        System.arraycopy(array, index + 1, array, index, size - (index + 1))
        size--
    }

    fun put(key: Int, value: V) {
        var index = Arrays.binarySearch(hashes, 0, size, key)
        if (index >= 0) array[index] = value
        else {
            index = index.inv()
            if (size >= hashes.size) {
                val newSize = if (size < ARRAY_MAP_SIZE_INDEX) ARRAY_MAP_SIZE_INDEX else size + (size shr 1)
                val tempHashes = hashes
                val tempArray = array
                allocArrays(newSize)

                System.arraycopy(tempHashes, 0, hashes, 0, tempHashes.size)
                System.arraycopy(tempArray, 0, array, 0, tempArray.size)
            }

            if (index < size) {
                System.arraycopy(hashes, index, hashes, index + 1, size - index)
                System.arraycopy(array, index, array, index + 1, size - index)
            }

            hashes[index] = key
            array[index] = value
            size++
        }
    }

    fun indexOfKey(key: Int): Int {
        return Arrays.binarySearch(hashes, 0, size, key)
    }

    fun containsKey(key: Int) = indexOfKey(key) >= 0

    fun keyAt(index: Int) = hashes[index]

    fun valueAt(index: Int) = array[index] as V

    fun setValueAt(index: Int, value: V) {
        array[index] = value
    }

    private fun allocArrays(size: Int) {
        hashes = IntArray(size)
        array = arrayOfNulls(size)
    }
}

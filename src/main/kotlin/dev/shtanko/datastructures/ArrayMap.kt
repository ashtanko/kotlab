package dev.shtanko.datastructures

import java.util.Arrays

private const val ARRAY_MAP_SIZE_INDEX = 4

class ArrayMap<K, V> constructor(capacity: Int = 0) {

    private lateinit var hashes: IntArray
    private lateinit var array: Array<Any?>

    var size = 0
        private set

    init {
        if (capacity <= 0) {
            hashes = IntArray(0)
            array = arrayOf()
        } else allocArrays(capacity)
    }

    fun isEmpty() = size <= 0

    operator fun get(key: K): V? {
        val index = indexOfKey(key)
        return if (index >= 0) array[(index shl 1) + 1] as V? else null
    }

    fun indexOfKey(key: K): Int {
        return if (key == null) indexOfNull() else indexOf(key)
    }

    fun containsKey(key: K) = indexOfKey(key) >= 0

    fun keyAt(index: Int) = array[index shl 1] as K

    fun valueAt(index: Int) = array[(index shl 1) + 1] as V

    fun setValueAt(index: Int, value: V): V? {
        val valueIndex = (index shl 1) + 1
        val old = array[valueIndex] as V
        array[valueIndex] = value
        return old
    }

    fun put(key: K, value: V): V? {
        val hash: Int
        var index: Int
        if (key == null) {
            hash = 0
            index = indexOfNull()
        } else {
            hash = key.hashCode()
            index = indexOf(key)
        }
        if (index >= 0) {
            // key-value pair already present
            index = (index shl 1) + 1
            val old = array[index] as V
            array[index] = value
            return old
        }

        index = index.inv()
        if (size >= hashes.size) {
            val shiftedSize = size shr 1
            val newSize = if (size < ARRAY_MAP_SIZE_INDEX) ARRAY_MAP_SIZE_INDEX else size + shiftedSize
            val tempHashes = hashes
            val tempArray = array
            allocArrays(newSize)

            System.arraycopy(tempHashes, 0, hashes, 0, tempHashes.size)
            System.arraycopy(tempArray, 0, array, 0, tempArray.size)
        }

        if (index < size) {
            System.arraycopy(hashes, index, hashes, index + 1, size - index)
            val increasedIndex = index + 1
            System.arraycopy(array, index shl 1, array, increasedIndex shl 1, size - index shl 1)
        }

        hashes[index] = hash
        array[index shl 1] = key
        array[(index shl 1) + 1] = value
        size++
        return null
    }

    fun remove(key: K): V? {
        val index = indexOfKey(key)
        if (index >= 0) return removeAt(index)
        return null
    }

    private fun removeAt(index: Int): V? {
        val oldVal = array[(index shl 1) + 1]
        val newSize = size - 1
        if (size <= 1) {
            // Empty Map
            hashes = IntArray(0)
            array = arrayOf()
        } else {
            System.arraycopy(hashes, index + 1, hashes, index, newSize - index)
            System.arraycopy(array, index + 1 shl 1, array, index shl 1, newSize - index shl 1)
            array[newSize shl 1] = null
            array[(newSize shl 1) + 1] = null
        }
        size = newSize
        return oldVal as V
    }

    private fun indexOf(key: K): Int {
        val hash = key!!.hashCode()

        if (size == 0) return 0.inv()
        val index = Arrays.binarySearch(hashes, 0, size, hash)

        // Key not found, return -ve value
        if (index < 0) return index

        if (key == array[index shl 1]) return index

        // Search for a matching key after the index.
        var end = index + 1
        while (end < size && hashes[end] == hash) {
            if (key == array[end shl 1]) return end
            end++
        }

        // Search for a matching key before the index.
        var i = index - 1
        while (i >= 0 && hashes[i] == hash) {
            if (key == array[i shl 1]) return i
            i--
        }
        return end.inv()
    }

    private fun indexOfNull(): Int {
        if (size == 0) return 0.inv()
        val index = Arrays.binarySearch(hashes, 0, size, 0)

        // Key not found, return -ve value
        if (index < 0) return index

        if (null == array[index shl 1]) return index

        // Search for a matching key after the index.
        var end = index + 1
        while (end < size && hashes[end] == 0) {
            if (null == array[end shl 1]) return end
            end++
        }

        // Search for a matching key before the index.
        var i = index - 1
        while (i >= 0 && hashes[i] == 0) {
            if (null == array[i shl 1]) return i
            i--
        }
        return end.inv()
    }

    private fun allocArrays(size: Int) {
        hashes = IntArray(size)
        array = arrayOfNulls(size shl 1) // size * 2
    }
}

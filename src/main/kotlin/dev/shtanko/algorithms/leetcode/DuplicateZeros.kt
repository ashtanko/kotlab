package dev.shtanko.algorithms.leetcode

fun duplicateZeros(arr: IntArray) {
    var countZero = 0
    for (element in arr) {
        if (element == 0) countZero++
    }
    val len: Int = arr.size + countZero
    // We just need O(1) space if we scan from back
    // i point to the original array, j point to the new location
    // We just need O(1) space if we scan from back
    // i point to the original array, j point to the new location

    var i: Int = arr.size - 1
    var j = len - 1
    while (i < j) {
        if (arr[i] != 0) {
            if (j < arr.size) arr[j] = arr[i]
        } else {
            if (j < arr.size) arr[j] = arr[i]
            j--
            if (j < arr.size) arr[j] = arr[i] // copy twice when hit '0'
        }
        i--
        j--
    }
}

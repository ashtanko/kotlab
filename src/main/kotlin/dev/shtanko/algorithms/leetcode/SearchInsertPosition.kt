package dev.shtanko.algorithms.leetcode

fun IntArray.searchInsertPosition(target: Int): Int {
    var low = 0
    var high = this.size - 1
    while (low <= high) {
        val mid = (low + high) / 2
        when {
            this[mid] == target -> {
                return mid
            }
            this[mid] > target -> {
                high = mid - 1
            }
            else -> {
                low = mid + 1
            }
        }
    }
    return low
}

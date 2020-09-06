package dev.shtanko.algorithms.leetcode

interface PeakIndexInMountainArrayStrategy {
    fun perform(arr: IntArray): Int
}

class PeakIndexInMountainArrayLinearScan : PeakIndexInMountainArrayStrategy {
    override fun perform(arr: IntArray): Int {
        var i = 0
        while (arr[i] < arr[i + 1]) i++
        return i
    }
}

class PeakIndexInMountainArrayBinarySearch : PeakIndexInMountainArrayStrategy {
    override fun perform(arr: IntArray): Int {
        var lo = 0
        var hi: Int = arr.size - 1
        while (lo < hi) {
            val mi = lo + (hi - lo) / 2
            if (arr[mi] < arr[mi + 1]) lo = mi + 1 else hi = mi
        }
        return lo
    }
}

class PeakIndexInMountainArrayBetterThanBinarySearch : PeakIndexInMountainArrayStrategy {
    override fun perform(arr: IntArray): Int {
        var i = 1
        while (i + 1 < arr.size) {
            if (arr[i] > arr[i + 1]) return i
            ++i
        }
        return 0
    }
}

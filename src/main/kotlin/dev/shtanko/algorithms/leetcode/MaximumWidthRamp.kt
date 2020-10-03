package dev.shtanko.algorithms.leetcode

import java.awt.Point
import java.util.ArrayList

interface MaximumWidthRampStrategy {
    fun maxWidthRamp(arr: IntArray): Int
}

class MaximumWidthRampSort : MaximumWidthRampStrategy {
    override fun maxWidthRamp(arr: IntArray): Int {
        val n: Int = arr.size
        val b = Array(n) { 0 }
        for (i in 0 until n) b[i] = i
        b.sortWith { i, j ->
            arr[i].compareTo(arr[j])
        }
        var ans = 0
        var m = n
        for (i in b) {
            ans = ans.coerceAtLeast(i - m)
            m = m.coerceAtMost(i)
        }

        return ans
    }
}

class MaximumWidthRampBinarySearch : MaximumWidthRampStrategy {
    override fun maxWidthRamp(arr: IntArray): Int {
        val n: Int = arr.size

        var ans = 0
        val candidates: MutableList<Point?> = ArrayList()
        candidates.add(Point(arr[n - 1], n - 1))

        // candidates: i's decreasing, by increasing value of A[i]
        for (i in n - 2 downTo 0) {
            // Find largest j in candidates with A[j] >= A[i]
            var lo = 0
            var hi = candidates.size
            while (lo < hi) {
                val local = hi - lo
                val mi = lo + local / 2
                candidates[mi]?.x?.let {
                    if (it < arr[i]) lo = mi + 1 else hi = mi
                }
            }
            if (lo < candidates.size) {
                val j: Int? = candidates[lo]?.y
                j?.let {
                    ans = ans.coerceAtLeast(it - i)
                }
            } else {
                candidates.add(Point(arr[i], i))
            }
        }
        return ans
    }
}

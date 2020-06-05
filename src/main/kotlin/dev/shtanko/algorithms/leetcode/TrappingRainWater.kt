package dev.shtanko.algorithms.leetcode

fun IntArray.trapRainWater(): Int {
    if (this.isEmpty()) return 0

    var low = 0
    var high = size - 1
    var maxLeft = 0
    var maxRight = 0
    var ans = 0

    while (low <= high) {
        if (this[low] <= this[high]) {
            if (this[low] >= maxLeft) maxLeft = this[low]
            else ans += maxLeft - this[low]
            low++
        } else {
            if (this[high] >= maxRight) maxRight = this[high]
            ans += maxRight - this[high]
            high--
        }
    }

    return ans
}

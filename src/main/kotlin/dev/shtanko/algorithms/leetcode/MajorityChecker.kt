package dev.shtanko.algorithms.leetcode

class MajorityChecker(val arr: IntArray) {

    fun query(left: Int, right: Int, threshold: Int): Int {
        var vote = -1
        var cnt = 0
        for (i in left..right) {
            if (cnt == 0) {
                vote = arr[i]
            }
            if (vote == arr[i]) {
                cnt++
            } else {
                cnt--
            }
        }
        cnt = 0
        for (i in left..right) {
            if (arr[i] == vote) {
                cnt++
            }
        }
        return if (cnt >= threshold) vote else -1
    }
}

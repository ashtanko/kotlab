package dev.shtanko.algorithms.leetcode

import java.util.Arrays
import kotlin.math.max
import kotlin.math.min

interface MeetingRoomsStrategy {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean
}

class MeetingRoomsBruteForce : MeetingRoomsStrategy {
    override fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        val n = intervals.size
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (overlap(intervals[i], intervals[j])) {
                    return false
                }
            }
        }
        return true
    }

    private fun overlap(i1: IntArray, i2: IntArray): Boolean {
        return min(i1[1], i2[1]) > max(i1[0], i2[0])
    }
}

class MeetingRoomsSorting : MeetingRoomsStrategy {
    override fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        Arrays.sort(intervals) { a, b -> a[0].compareTo(b[0]) }
        for (i in 0 until intervals.size - 1) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false
            }
        }
        return true
    }
}

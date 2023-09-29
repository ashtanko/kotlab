/*
 * Copyright 2022 Oleksii Shtanko
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

package dev.shtanko.algorithms.leetcode

import kotlin.math.abs

/**
 * 2037. Minimum Number of Moves to Seat Everyone
 * @see <a href="https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/">Source</a>
 */
fun interface MinMovesToSeat {
    operator fun invoke(seats: IntArray, students: IntArray): Int
}

class MinMovesToSeatBruteForce : MinMovesToSeat {
    override operator fun invoke(seats: IntArray, students: IntArray): Int {
        var moves = 0
        seats.sort()
        students.sort()
        for (i in seats.indices) {
            val seat = seats[i]
            val student = students[i]
            if (seat > student) {
                moves += seat.minus(student)
            } else if (student > seat) {
                moves += student.minus(seat)
            }
        }
        return moves
    }
}

class MinMovesToSeatMath : MinMovesToSeat {
    override operator fun invoke(seats: IntArray, students: IntArray): Int {
        var moves = 0
        seats.sort()
        students.sort()
        for (i in seats.indices) {
            val seat = seats[i]
            val student = students[i]
            moves += abs(seat - student)
        }
        return moves
    }
}

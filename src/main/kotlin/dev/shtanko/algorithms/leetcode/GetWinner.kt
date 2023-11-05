package dev.shtanko.algorithms.leetcode

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

/**
 * 1535. Find the Winner of an Array Game
 * @see <a href="https://leetcode.com/problems/find-the-winner-of-an-array-game">Source</a>
 */
fun interface GetWinner {
    operator fun invoke(arr: IntArray, k: Int): Int
}

sealed interface GetWinnerStrategy {
    data object QueueSolution : GetWinner, GetWinnerStrategy {
        override fun invoke(arr: IntArray, k: Int): Int {
            var maxElement = arr[0]
            val queue: Queue<Int> = LinkedList()
            for (i in 1 until arr.size) {
                maxElement = max(maxElement, arr[i])
                queue.offer(arr[i])
            }

            var curr = arr[0]
            var winstreak = 0

            while (!queue.isEmpty()) {
                val opponent: Int = queue.poll()
                if (curr > opponent) {
                    queue.offer(opponent)
                    winstreak++
                } else {
                    queue.offer(curr)
                    curr = opponent
                    winstreak = 1
                }
                if (winstreak == k || curr == maxElement) {
                    return curr
                }
            }

            return -1
        }
    }

    data object NoQueueSolution : GetWinner, GetWinnerStrategy {
        override fun invoke(arr: IntArray, k: Int): Int {
            var maxElement = arr[0]
            for (i in 1 until arr.size) {
                maxElement = max(maxElement, arr[i])
            }

            var curr = arr[0]
            var winstreak = 0

            for (i in 1 until arr.size) {
                val opponent = arr[i]
                if (curr > opponent) {
                    winstreak++
                } else {
                    curr = opponent
                    winstreak = 1
                }
                if (winstreak == k || curr == maxElement) {
                    return curr
                }
            }

            return -1
        }
    }
}

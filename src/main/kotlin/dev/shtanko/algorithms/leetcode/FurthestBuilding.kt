/*
 * Copyright 2021 Oleksii Shtanko
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

import java.util.PriorityQueue
import java.util.Queue
import kotlin.math.max
import kotlin.math.min

/**
 * Furthest Building You Can Reach
 * @link https://leetcode.com/problems/furthest-building-you-can-reach/
 */
interface FurthestBuilding {
    fun perform(heights: IntArray, bricks: Int, ladders: Int): Int
}

/**
 * Approach 1: Min-Heap
 * Time complexity : O(N log N) or O(N log L).
 * Space complexity : O(N) or O(L).
 */
class MinHeap : FurthestBuilding {
    override fun perform(heights: IntArray, bricks: Int, ladders: Int): Int {
        // Create a priority queue with a comparator that makes it behave as a min-heap.
        val ladderAllocations: Queue<Int> = PriorityQueue { a, b -> a - b }
        var b = bricks
        for (i in 0 until heights.size - 1) {
            val climb = heights[i + 1] - heights[i]
            // If this is actually a "jump down", skip it.
            if (climb <= 0) {
                continue
            }
            // Otherwise, allocate a ladder for this climb.
            ladderAllocations.add(climb)
            // If we haven't gone over the number of ladders, nothing else to do.
            if (ladderAllocations.size <= ladders) {
                continue
            }
            // Otherwise, we will need to take a climb out of ladder_allocations
            b -= ladderAllocations.remove()
            // If this caused bricks to go negative, we can't get to i + 1
            if (b < 0) {
                return i
            }
        }
        // If we got to here, this means we had enough materials to cover every climb.
        return heights.size - 1
    }
}

/**
 * Approach 2: Max-Heap
 * Time complexity : O(N log N).
 * Space complexity : O(N).
 */
class MaxHeap : FurthestBuilding {
    override fun perform(heights: IntArray, bricks: Int, ladders: Int): Int {
        // Create a priority queue with a comparator that makes it behave as a max-heap.
        val brickAllocations: Queue<Int> = PriorityQueue { a: Int, b: Int -> b - a }
        var b = bricks
        var l = ladders
        for (i in 0 until heights.size - 1) {
            val climb = heights[i + 1] - heights[i]
            // If this is actually a "jump down", skip it.
            if (climb <= 0) {
                continue
            }
            // Otherwise, allocate a ladder for this climb.
            brickAllocations.add(climb)
            b -= climb
            // If we've used all the bricks, and have no ladders remaining, then
            // we can't go any further.
            if (b < 0 && l == 0) {
                return i
            }
            // Otherwise, if we've run out of bricks, we should replace the largest
            // brick allocation with a ladder.
            if (b < 0) {
                b += brickAllocations.remove()
                l--
            }
        }
        // If we got to here, this means we had enough materials to cover every climb.
        return heights.size - 1
    }
}

/**
 * Approach 3: Binary Search for Final Reachable Building
 * Time complexity : O(N log² N).
 * Space complexity : O(N).
 */
class FinalReachableBuilding : FurthestBuilding {
    override fun perform(heights: IntArray, bricks: Int, ladders: Int): Int {
        // Do a binary search on the heights array to find the final reachable building.
        // Do a binary search on the heights array to find the final reachable building.
        var lo = 0
        var hi: Int = heights.size - 1
        while (lo < hi) {
            val mid = lo + (hi - lo + 1) / 2
            if (isReachable(mid, heights, bricks, ladders)) {
                lo = mid
            } else {
                hi = mid - 1
            }
        }
        return hi // Note that return lo would be equivalent.
    }

    private fun isReachable(buildingIndex: Int, heights: IntArray, bricks: Int, ladders: Int): Boolean {
        // Make a list of all the climbs we need to do to reach buildingIndex.
        var b = bricks
        var l = ladders
        val climbs: MutableList<Int> = ArrayList()
        for (i in 0 until buildingIndex) {
            val h1 = heights[i]
            val h2 = heights[i + 1]
            if (h2 <= h1) {
                continue
            }
            climbs.add(h2 - h1)
        }
        climbs.sort()

        // And now determine whether or not all of these climbs can be covered with the
        // given bricks and ladders.
        for (climb in climbs) {
            // If there are bricks left, use those.
            when {
                climb <= b -> {
                    b -= climb
                    // Otherwise, you'll have to use a ladder.
                }
                l >= 1 -> {
                    l -= 1
                    // And if there are no ladders either, we can't reach buildingIndex.
                }
                else -> {
                    return false
                }
            }
        }
        return true
    }
}

/**
 * Approach 4: Improved Binary Search for Final Reachable Building
 * Time complexity : O(N log N).
 * Space complexity : O(N).
 */
class ImprovedFinalReachableBuilding : FurthestBuilding {
    override fun perform(heights: IntArray, bricks: Int, ladders: Int): Int {
        // Make a sorted list of all the climbs.
        val sortedClimbs: MutableList<IntArray> = ArrayList()
        for (i in 0 until heights.size - 1) {
            val climb = heights[i + 1] - heights[i]
            if (climb <= 0) {
                continue
            }
            sortedClimbs.add(intArrayOf(climb, i + 1))
        }
        sortedClimbs.sortWith { a: IntArray, b: IntArray -> a[0] - b[0] }

        // Now do the binary search, same as before.
        var lo = 0
        var hi: Int = heights.size - 1
        while (lo < hi) {
            val mid = lo + (hi - lo + 1) / 2
            if (isReachable(mid, sortedClimbs, bricks, ladders)) {
                lo = mid
            } else {
                hi = mid - 1
            }
        }
        return hi // Note that return lo would be equivalent.
    }

    private fun isReachable(buildingIndex: Int, climbs: List<IntArray>, bricks: Int, ladders: Int): Boolean {
        var b = bricks
        var l = ladders
        for (climbEntry in climbs) {
            // Extract the information for this climb
            val climb = climbEntry[0]
            val index = climbEntry[1]
            // Check if this climb is within the range.
            if (index > buildingIndex) {
                continue
            }
            // Allocate bricks if enough remain; otherwise, allocate a ladder if
            // at least one remains.
            when {
                climb <= b -> {
                    b -= climb
                }
                l >= 1 -> {
                    l -= 1
                }
                else -> {
                    return false
                }
            }
        }
        return true
    }
}

/**
 * Approach 5: Binary Search on Threshold (Advanced)
 * Time complexity : O(N log(maxClimb)).
 * Space complexity : O(1).
 */
class BSThreshold : FurthestBuilding {
    override fun perform(heights: IntArray, bricks: Int, ladders: Int): Int {
        var lo = Int.MAX_VALUE
        var hi = Int.MIN_VALUE
        for (i in 0 until heights.size - 1) {
            val climb = heights[i + 1] - heights[i]
            if (climb <= 0) {
                continue
            }
            lo = min(lo, climb)
            hi = max(hi, climb)
        }
        if (lo == Int.MAX_VALUE) {
            return heights.size - 1
        }
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            val result = solveWithGivenThreshold(heights, bricks, ladders, mid)
            val indexReached = result[0]
            val laddersRemaining = result[1]
            val bricksRemaining = result[2]
            if (indexReached == heights.size - 1) {
                return heights.size - 1
            }
            if (laddersRemaining > 0) {
                hi = mid - 1
                continue
            }
            // Otherwise, check whether this is the "too low" or "just right" case.
            val nextClimb = heights[indexReached + 1] - heights[indexReached]
            lo = if (nextClimb > bricksRemaining && mid > bricksRemaining) {
                return indexReached
            } else {
                mid + 1
            }
        }
        return -1 // It always returns before here. But gotta keep Java happy.
    }

    private fun solveWithGivenThreshold(heights: IntArray, bricks: Int, ladders: Int, k: Int): IntArray {
        var bricksCount = bricks
        var laddersCount = ladders
        var laddersUsedOnThreshold = 0
        for (i in 0 until heights.size - 1) {
            val climb = heights[i + 1] - heights[i]
            if (climb <= 0) {
                continue
            }
            // Make resource allocations
            when {
                climb == k -> {
                    laddersUsedOnThreshold++
                    laddersCount--
                }
                climb > k -> {
                    laddersCount--
                }
                else -> {
                    bricksCount -= climb
                }
            }
            // Handle negative resources
            if (laddersCount < 0) {
                bricksCount -= if (laddersUsedOnThreshold >= 1) {
                    laddersUsedOnThreshold--
                    laddersCount++
                    k
                } else {
                    return intArrayOf(i, laddersCount, bricksCount)
                }
            }
            if (bricksCount < 0) {
                return intArrayOf(i, laddersCount, bricksCount)
            }
        }
        return intArrayOf(heights.size - 1, laddersCount, bricksCount)
    }
}

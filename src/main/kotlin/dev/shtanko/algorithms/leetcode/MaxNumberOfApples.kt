package dev.shtanko.algorithms.leetcode

import java.util.PriorityQueue
import java.util.Queue
import kotlin.math.max
import kotlin.math.min

private const val BASKET_SIZE = 5000

/**
 * How Many Apples Can You Put into the Basket.
 * You have some apples, where arr[i] is the weight of the i-th apple.
 * You also have a basket that can carry up to 5000 units of weight.
 * Return the maximum number of apples you can put in the basket.
 */
interface MaxNumberOfApples {
    fun perform(arr: IntArray): Int
}

/**
 * Time Complexity: O(NlogN).
 * Space Complexity: O(1).
 */
class MaxNumberOfApplesSort : MaxNumberOfApples {
    override fun perform(arr: IntArray): Int {
        arr.sort()
        var apples = 0
        var units = 0
        var i = 0
        while (i < arr.size && units + arr[i] <= BASKET_SIZE) {
            apples++
            units += arr[i]
            i++
        }

        return apples
    }
}

/**
 * Time Complexity: O(NlogN).
 * Space Complexity: O(1).
 */
class MaxNumberOfApplesMinHeap : MaxNumberOfApples {
    override fun perform(arr: IntArray): Int {
        val heap: Queue<Int> = PriorityQueue()
        var apples = 0
        var units = 0
        for (weight in arr) {
            heap.add(weight)
        }

        while (heap.isNotEmpty() && units + heap.peek() <= BASKET_SIZE) {
            units += heap.remove()
            apples++
        }

        return apples
    }
}

/**
 * Time Complexity: O(N + W). , where N is the length of arr and W is the largest element in arr.
 * This is because we iterate through arr and bucket once and the lengths are N and W accordingly.
 * Space Complexity: O(W). This is because we initialize an array bucket with the size of max(arr).
 */
class MaxNumberOfApplesBucketSort : MaxNumberOfApples {
    override fun perform(arr: IntArray): Int {
        // initialize the bucket to store all elements
        var size = -1
        for (weight in arr) {
            size = max(size, weight)
        }
        val bucket = IntArray(size + 1)
        for (weight in arr) {
            bucket[weight]++
        }

        var apples = 0
        var units = 0
        for (i in 0 until size + 1) {
            // if we have apples of i units of weight
            if (bucket[i] != 0) {
                // we need to make sure that:
                // 1. we do not take more apples than those provided
                // 2. we do not exceed 5000 units of weight
                val take = min(bucket[i], (BASKET_SIZE - units) / i)
                if (take == 0) {
                    break
                }
                units += take * i
                apples += take
            }
        }
        return apples
    }
}

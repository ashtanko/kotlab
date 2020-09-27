package dev.shtanko.algorithms.leetcode

interface ContainerWithMostWaterStrategy {
    fun maxArea(height: IntArray): Int
}

class ContainerWithMostWaterBruteForce : ContainerWithMostWaterStrategy {
    override fun maxArea(height: IntArray): Int {
        var maxArea = 0
        for (i in height.indices) {
            for (j in i + 1 until height.size) {
                maxArea = maxArea.coerceAtLeast(height[i].coerceAtMost(height[j]) * (j - i))
            }
        }
        return maxArea
    }
}

class ContainerWithMostWaterTwoPointer : ContainerWithMostWaterStrategy {
    override fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var l = 0
        var r: Int = height.size - 1
        while (l < r) {
            maxArea = maxArea.coerceAtLeast(height[l].coerceAtMost(height[r]) * (r - l))
            if (height[l] < height[r]) l++ else r--
        }
        return maxArea
    }
}

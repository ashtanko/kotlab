package dev.shtanko.dynamicprogramming

import kotlin.math.max

// solve the problem using dynamic programming
fun cutRod(price: IntArray, n: Int): Int {
    // Declaring a 2D array, T
    val arr = Array(n - 1) { IntArray(n + 1) }

    // Initializing the array to all zeros
    for (i in 0 until n - 1) {
        for (j in 0 until n + 1) {
            arr[i][j] = 0
        }
    }
    for (i in 0 until n - 1) {
        for (j in 0 until n + 1) {
            // First column => 0 length of rod => 0 profit
            if (j == 0) {
                continue
            } else if (i == 0) {
                arr[i][j] = price[i] + arr[i][j - i - 1]
            } else if (j - i - 1 < 0) {
                arr[i][j] = arr[i - 1][j]
            } else {
                arr[i][j] = max(arr[i - 1][j], price[i] + arr[i][j - i - 1])
            }
        }
    }
    return arr[n - 2][n]
}

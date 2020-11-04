package dev.shtanko.algorithms.interview

import java.util.Stack

fun sortStack(input: Stack<Int>): Stack<Int> {
    val sortedOutput = Stack<Int>()

    while (!input.empty()) {
        val smallestValue = input.pop()

        while (!sortedOutput.empty() && sortedOutput.peek() < smallestValue) {
            input.push(sortedOutput.pop())
        }

        sortedOutput.push(smallestValue)
    }

    return sortedOutput
}

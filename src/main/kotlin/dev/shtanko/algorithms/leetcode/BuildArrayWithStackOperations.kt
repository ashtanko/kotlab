package dev.shtanko.algorithms.leetcode

// Build an Array With Stack Operations
class BuildArrayWithStackOperations {

    companion object {
        private const val PUSH = "Push"
        private const val POP = "Pop"
    }

    fun perform(target: IntArray, n: Int): MutableList<String> {
        val result: MutableList<String> = ArrayList()
        var j = 0
        var i = 1
        while (i <= n && j < target.size) {
            result.add(PUSH)
            if (target[j] == i) {
                j++
            } else {
                result.add(POP)
            }
            i++
        }
        return result
    }
}

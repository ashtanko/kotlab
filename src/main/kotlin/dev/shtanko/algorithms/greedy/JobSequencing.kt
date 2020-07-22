package dev.shtanko.algorithms.greedy

import java.util.Arrays

internal data class Job(
    var id: Char = ' ',
    var deadline: Int = 0,
    private var profit: Int = 0
) : Comparator<Job> {
    override fun compare(j1: Job, j2: Job): Int {
        return if (j1.profit > j2.profit) -1 else 1
    }
}

internal fun Array<Job>.scheduleJobs(): MutableList<Char> {
    Arrays.sort(this, Job())
    val n = size
    val result = IntArray(n) // To store result (Sequence of jobs)
    val slot = BooleanArray(n) // To keep track of free time slots

    // Initialize all slots to be free
    for (i in 0 until n)
        slot[i] = false

    // Iterate through all given jobs
    for (i in 0 until n) {
        // Find a free slot for this job
        for (j in kotlin.math.min(n, this[i].deadline) - 1 downTo 0) {
            // Free slot found
            if (!slot[j]) {
                result[j] = i // Add this job to result
                slot[j] = true // Make this slot occupied
                break
            }
        }
    }

    val res = mutableListOf<Char>()
    // Print the result
    for (i in 0 until n) {
        if (slot[i]) {
            val ch = this[result[i]].id
            res.add(ch)
        }
    }
    return res
}

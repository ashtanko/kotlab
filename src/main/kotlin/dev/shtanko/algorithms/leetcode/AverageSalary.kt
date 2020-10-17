package dev.shtanko.algorithms.leetcode

/**
 * Given an array of unique integers salary where salary[i] is the salary of the employee i.
 */
fun IntArray.averageSalary(): Double {
    var sum = 0.0
    var min = Int.MAX_VALUE
    var max = 0
    for (salary in this) {
        sum += salary
        if (salary < min) {
            min = salary
        }
        if (salary > max) {
            max = salary
        }
    }
    return sum.minus(max).minus(min) / size.minus(2)
}

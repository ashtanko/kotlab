package dev.shtanko.utils

import kotlin.random.Random

fun merge(array: IntArray, helper: IntArray, low: Int, middle: Int, high: Int) {
    for (i in low..high) {
        helper[i] = array[i]
    }
    var helperLeft = low
    var helperRight = middle + 1
    var current = low
    while (helperLeft <= middle && helperRight <= high) {
        if (helper[helperLeft] <= helper[helperRight]) {
            array[current] = helper[helperLeft++]
        } else {
            array[current] = helper[helperRight++]
        }
        current++
    }
    while (helperLeft <= middle) {
        array[current++] = helper[helperLeft++]
    }
}

fun Int.toRandomArray(): IntArray {
    val array = IntArray(this)
    for (i in 0 until this) {
        array[i] = Random.nextInt(this)
    }
    return array
}

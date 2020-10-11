package dev.shtanko.algorithms.leetcode

class DesignParkingSystem(big: Int, medium: Int, small: Int) {
    private val count = intArrayOf(big, medium, small)

    fun addCar(carType: Int) = count[carType.minus(1)]-- > 0
}

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DesignParkingSystemTest {

    @Test
    fun `simple test`() {
        val parkingSystem = DesignParkingSystem(1, 1, 0)
        assertTrue(parkingSystem.addCar(1))
        assertTrue(parkingSystem.addCar(2))
        assertFalse(parkingSystem.addCar(3))
        assertFalse(parkingSystem.addCar(1))
    }
}
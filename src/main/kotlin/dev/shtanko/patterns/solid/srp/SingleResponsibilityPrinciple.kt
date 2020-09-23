package dev.shtanko.patterns.solid.srp

import org.slf4j.LoggerFactory

object SingleResponsibilityPrinciple {
    private val LOGGER = LoggerFactory.getLogger(SingleResponsibilityPrinciple::class.java)

    class Robot(val name: String, val type: String) {

        // Violation
        fun greet() {
            LOGGER.info("Hello my name is $name, and I am a $type robot")
        }
    }

    // Solution
    class RobotPrinter {
        fun greet(robot: Robot) {
            val name = robot.name
            val type = robot.type
            LOGGER.info("Hello my name is $name, and I am a $type robot")
        }
    }
}

package dev.shtanko.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class App

fun main() {
    runApplication<App>()
}

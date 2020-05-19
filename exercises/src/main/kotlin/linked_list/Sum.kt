package linked_list

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val sum = try {
        scanner.nextInt() + scanner.nextInt()
    } catch (e: Exception) {
        e.printStackTrace()
        0
    } finally {
        scanner.close()
    }

    println(sum)
}
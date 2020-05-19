package linked_list

import java.io.File
import java.io.FileNotFoundException
import java.io.PrintWriter
import java.lang.Exception
import java.util.Scanner

fun main() {
    val sum = try {
        val scanner = Scanner(File("input.txt"))
        scanner.nextInt() + scanner.nextInt()
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
        0
    }

    try {
        PrintWriter(File("output.txt")).apply {
            println(sum)
            close()
        }

    } catch (e: Exception) {
        e.printStackTrace()
    }
}
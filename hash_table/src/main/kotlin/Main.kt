import java.lang.RuntimeException
import java.util.Hashtable

val table: Array<Array<Int>> = arrayOf(
    arrayOf(-1, -1, -1, -1),
    arrayOf(-1, -1, -1, -1),
    arrayOf(-1, -1, -1, -1),
    arrayOf(-1, -1, -1, -1),
    arrayOf(-1, -1, -1, -1),
    arrayOf(-1, -1, -1, -1),
    arrayOf(-1, -1, -1, -1),
    arrayOf(-1, -1, -1, -1)
)

fun changeQueen(i:Int, j:Int) {
    table[i][j] = 0
}

fun main() {


    changeQueen(0, 3)
    printTable(table)
}

private fun printTable(table: Array<Array<Int>>) {
    for (ints in table) {
        println(ints.toList())
    }
}

// # # # # # # # #
// # # # # # # # #
// # # # # # # # #
// # # # # # # # #
// # # # # # # # #
// # # # # # # # #
// # # # # # # # #
// # # # # # # # #
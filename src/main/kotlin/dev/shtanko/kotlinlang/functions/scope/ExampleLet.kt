package dev.shtanko.kotlinlang.functions.scope

class ExampleLet {
    fun isEmpty(str: String) = str.let {
        println(it)
        it.isEmpty()
    }

    fun printNonNull(str: String?) {
        println("Printing \"$str\":")
        str?.let {
            print("\t")
            println(it)
            println()
        }
    }
}

import java.util.*

fun main() {
    val tree = TreeMap<String, String>()

    tree["C"] = "Foo"
    tree["A"] = "Bar"
    tree["R"] = "Root"
    tree["B"] = "Boring"

    for( i in tree) {
        println("${i}")
    }

    println(tree.get("R"))


}
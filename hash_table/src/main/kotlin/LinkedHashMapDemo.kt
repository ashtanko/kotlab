/**
 * LinkedHashMap is just like HashMap with an additional feature of maintaining an order of elements inserted into it.
 * @link https://www.geeksforgeeks.org/linkedhashmap-class-java-examples/
 */
fun main() {

    val lhm = LinkedHashMap<String, String>()
    lhm["one"] = "practice.geeksforgeeks.org"
    lhm["two"] = "code.geeksforgeeks.org"
    lhm["four"] = "quiz.geeksforgeeks.org"
    // It prints the elements in same order
    // as they were inserted
    println(lhm)

    println("Getting value for key 'one': "
        + lhm.get("one"))
    println("Size of the map: " + lhm.size)
    println("Is map empty? " + lhm.isEmpty())
    println("Contains key 'two'? "+
        lhm.containsKey("two"))
    println("Contains value 'practice.geeks"
        +"forgeeks.org'? "+ lhm.containsValue("practice"+
        ".geeksforgeeks.org"))
    println("delete element 'one': " +
        lhm.remove("one"))
    println(lhm)
}

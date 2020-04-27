object Deck {
    @JvmStatic
    fun main(args: Array<String>) {
        val rank = arrayOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
        val suit = arrayOf("♣", "♦", "♥", "♠")
        val deck = arrayOfNulls<String>(52)
        for (j in suit.indices) {
            for (i in rank.indices) {
                val a = i + 13 * j
                println("a = $a")
                deck[i + 13 * j] = rank[i] + suit[j]
            }
        }

        for (i in 0 until 52){
            print(deck[i])
        }
    }
}
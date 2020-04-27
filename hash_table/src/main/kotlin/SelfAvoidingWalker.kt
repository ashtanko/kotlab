object SelfAvoidingWalker {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isEmpty()) {
            println("Error: args is empty")
            return
        }
        val n = Integer.parseInt(args[0])
        if (args.size == 1) {
            return
        }

        val trials = Integer.parseInt(args[1])
        println("$n $trials")

        var deadEnds = 0
        for (i in 0 until trials) {
            val a = Array(n) { BooleanArray(n) }
            var x = n / 2
            var y = n / 2

            while (x > 0 && x < n - 1 && y > 0 && y < n - 1) {
                if (a[x - 1][y] && a[x + 1][y] && a[x][y - 1] && a[x][y + 1]) {
                    deadEnds++
                    break
                }
                a[x][y] = true
                val r = Math.random()
                if (r < 0.25) {
                    if (!a[x + 1][y]) x++
                } else if (r < 0.50) {
                    if (!a[x - 1][y]) x--
                } else if (r < 0.75) {
                    if (!a[x][y + 1]) y++
                } else if (r < 1.00) {
                    if (!a[x][y - 1]) y--
                }
            }
            println("${100 * deadEnds / trials}% dead ends");
        }
    }
}
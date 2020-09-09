package dev.shtanko.algorithms.leetcode

fun judgeCircle(moves: String): Boolean {
    var x = 0
    var y = 0
    for (move in moves.toCharArray()) {
        if (move == 'U') y-- else if (move == 'D') y++ else if (move == 'L') x-- else if (move == 'R') x++
    }
    return x == 0 && y == 0
}

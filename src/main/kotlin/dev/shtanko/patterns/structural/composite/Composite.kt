package dev.shtanko.patterns.structural.composite

open class LetterComposite {

    private val children: MutableList<LetterComposite> = ArrayList()

    fun add(letter: LetterComposite) {
        children.add(letter)
    }

    fun count(): Int {
        return children.size
    }

    open fun printThisBefore() {}

    open fun printThisAfter() {}

    fun print() {
        printThisBefore()
        children.forEach(LetterComposite::print)
        printThisAfter()
    }
}

class Letter(private val character: Char) : LetterComposite() {
    override fun printThisBefore() {
        print(character)
    }
}

class Word(vararg letters: Char) : LetterComposite() {
    init {
        for (letter in letters) {
            this.add(Letter(letter))
        }
    }

    override fun printThisBefore() {
        print(" ")
    }
}

class Sentence(private val words: List<Word>) : LetterComposite() {
    init {
        words.forEach(this::add)
    }

    override fun printThisAfter() {
        print(".")
    }
}

class Messenger {
    fun messageFromOrcs(): LetterComposite {
        val words = listOf(
            Word('W', 'h', 'e', 'r', 'e'),
            Word('t', 'h', 'e', 'r', 'e'),
            Word('i', 's'),
            Word('a'),
            Word('w', 'h', 'i', 'p'),
            Word('t', 'h', 'e', 'r', 'e'),
            Word('i', 's'),
            Word('a'),
            Word('w', 'a', 'y')
        )
        return Sentence(words)
    }

    fun messageFromElves(): LetterComposite {
        val words = listOf(
            Word('M', 'u', 'c', 'h'),
            Word('w', 'i', 'n', 'd'),
            Word('p', 'o', 'u', 'r', 's'),
            Word('f', 'r', 'o', 'm'),
            Word('y', 'o', 'u', 'r'),
            Word('m', 'o', 'u', 't', 'h')
        )
        return Sentence(words)
    }
}

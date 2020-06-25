package dev.shtanko.patterns.structural.composite

open class Equipment(private var price: Int, private var name: String) {
    open fun getPrice(): Int = price
}

open class Composite(name: String) : Equipment(0, name) {
    private val equipments = ArrayList<Equipment>()

    fun add(equipment: Equipment) {
        this.equipments.add(equipment)
    }

    override fun getPrice(): Int {
        return equipments.map { it.getPrice() }.sum()
    }
}

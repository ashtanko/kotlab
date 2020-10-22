package dev.shtanko.patterns.creational.abstractfactory

interface Plant

class OrangePlant : Plant

class ApplePlant : Plant

interface PlantFactory {

    fun makePlant(): Plant

    companion object {
        inline fun <reified T : Plant> createFactory(): PlantFactory =
            when (T::class) {
                OrangePlant::class -> OrangeFactory()
                ApplePlant::class -> AppleFactory()
                else -> throw IllegalArgumentException()
            }
    }
}

class AppleFactory : PlantFactory {
    override fun makePlant(): Plant = ApplePlant()
}

class OrangeFactory : PlantFactory {
    override fun makePlant(): Plant = OrangePlant()
}

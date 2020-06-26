package dev.shtanko.patterns.structural.bridge

import org.slf4j.LoggerFactory

interface Enchantment {
    fun onActivate()

    fun apply()

    fun onDeactivate()
}

interface Weapon {
    fun wield()

    fun swing()

    fun unWield()

    val enchantment: Enchantment
}

class FlyingEnchantment : Enchantment {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(FlyingEnchantment::class.java)
    }

    override fun onActivate() {
        LOGGER.info("The item begins to glow faintly.")
    }

    override fun apply() {
        LOGGER.info("The item flies and strikes the enemies finally returning to owner's hand.")
    }

    override fun onDeactivate() {
        LOGGER.info("The item's glow fades.")
    }
}

class SoulEatingEnchantment : Enchantment {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(SoulEatingEnchantment::class.java)
    }

    override fun onActivate() {
        LOGGER.info("The item spreads bloodlust.")
    }

    override fun apply() {
        LOGGER.info("The item eats the soul of enemies.")
    }

    override fun onDeactivate() {
        LOGGER.info("Bloodlust slowly disappears.")
    }
}

class Hammer(override val enchantment: Enchantment) : Weapon {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(Hammer::class.java)
    }

    override fun wield() {
        LOGGER.info("The hammer is wielded.")
        enchantment.onActivate()
    }

    override fun swing() {
        LOGGER.info("The hammer is swinged.")
        enchantment.apply()
    }

    override fun unWield() {
        LOGGER.info("The hammer is unwielded.")
        enchantment.onDeactivate()
    }
}

class Sword(override val enchantment: Enchantment) : Weapon {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(Sword::class.java)
    }

    override fun wield() {
        LOGGER.info("The sword is wielded.")
        enchantment.onActivate()
    }

    override fun swing() {
        LOGGER.info("The sword is swinged.")
        enchantment.apply()
    }

    override fun unWield() {
        LOGGER.info("The sword is unwielded.")
        enchantment.onDeactivate()
    }
}

object App {
    private val LOGGER = LoggerFactory.getLogger(App::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        LOGGER.info("The knight receives an enchanted sword.")
        val enchantedSword = Sword(SoulEatingEnchantment())
        enchantedSword.wield()
        enchantedSword.swing()
        enchantedSword.unWield()

        LOGGER.info("The valkyrie receives an enchanted hammer.")
        val hammer = Hammer(FlyingEnchantment())
        hammer.wield()
        hammer.swing()
        hammer.unWield()
    }
}

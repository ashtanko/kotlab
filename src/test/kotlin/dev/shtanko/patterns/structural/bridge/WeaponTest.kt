package dev.shtanko.patterns.structural.bridge

import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions

abstract class WeaponTest {

    fun testBasicWeaponActions(weapon: Weapon) {

        val enchantment = weapon.enchantment
        weapon.swing()

        verify(enchantment).apply()
        verifyNoMoreInteractions(enchantment)

        weapon.wield()
        verify(enchantment).onActivate()
        verifyNoMoreInteractions(enchantment)

        weapon.unWield()
        verify(enchantment).onDeactivate()
        verifyNoMoreInteractions(enchantment)
    }
}

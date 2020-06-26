package dev.shtanko.patterns.structural.bridge

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.spy

class SwordTest : WeaponTest() {

    @Test
    fun `sword test`() {
        val sword = spy(Sword(mock(FlyingEnchantment::class.java)))
        testBasicWeaponActions(sword)
    }
}

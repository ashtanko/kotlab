package dev.shtanko.patterns.structural.bridge

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.spy

class HammerTest : WeaponTest() {

    @Test
    fun `hammer test`() {
        val hammer = spy(Hammer(mock(FlyingEnchantment::class.java)))
        testBasicWeaponActions(hammer)
    }
}

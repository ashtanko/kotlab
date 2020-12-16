package dev.shtanko.patterns.structural.decorator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.spy
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions

internal class ClubbedTrollTest {

    @Test
    internal fun `clubbed troll test`() {
        val simpleTroll = spy(SimpleTroll())

        val clubbed = ClubbedTroll(simpleTroll)
        assertEquals(20, clubbed.getAttackPower())

        verify(simpleTroll, times(1)).getAttackPower()

        // Check if the clubbed troll actions are delegated to the decorated troll
        clubbed.attack()
        verify(simpleTroll, times(1)).attack()

        clubbed.fleeBattle()
        verify(simpleTroll, times(1)).fleeBattle()
        verifyNoMoreInteractions(simpleTroll)
    }
}

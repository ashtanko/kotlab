package dev.shtanko.patterns.behavioral.mediator

import com.nhaarman.mockitokotlin2.verifyZeroInteractions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions

class PartyTest {

    @Test
    fun `party action test`() {
        val partyMember1 = mock(PartyMember::class.java)
        val partyMember2 = mock(PartyMember::class.java)
        val party: Party = PartyImpl()
        party.addMember(partyMember1)
        party.addMember(partyMember2)

        verify<PartyMember>(partyMember1).joinedParty(party)
        verify<PartyMember>(partyMember2).joinedParty(party)

        party.act(partyMember1, Action.GOLD)
        verifyZeroInteractions(partyMember1)
        verify<PartyMember>(partyMember2).partyAction(Action.GOLD)

        verifyNoMoreInteractions(partyMember1, partyMember2)
    }
}

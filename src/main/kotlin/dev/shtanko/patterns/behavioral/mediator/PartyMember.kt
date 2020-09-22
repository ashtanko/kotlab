package dev.shtanko.patterns.behavioral.mediator

interface PartyMember {
    fun joinedParty(party: Party)

    fun partyAction(action: Action)

    fun act(action: Action)
}

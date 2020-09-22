package dev.shtanko.patterns.behavioral.mediator

interface Party {

    fun addMember(member: PartyMember)

    fun act(actor: PartyMember, action: Action)
}

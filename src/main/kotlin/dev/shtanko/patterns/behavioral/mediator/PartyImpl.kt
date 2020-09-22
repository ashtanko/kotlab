package dev.shtanko.patterns.behavioral.mediator

class PartyImpl : Party {

    private val members: MutableList<PartyMember> = ArrayList()

    override fun addMember(member: PartyMember) {
        members.add(member)
        member.joinedParty(this)
    }

    override fun act(actor: PartyMember, action: Action) {
        for (member in members) {
            if (member != actor) {
                member.partyAction(action)
            }
        }
    }
}

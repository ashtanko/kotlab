package dev.shtanko.patterns.behavioral.iterator.list

import dev.shtanko.patterns.behavioral.iterator.CustomIterator

class TreasureChest {

    val items = listOf(
        Item(ItemType.POTION, "Potion of courage"),
        Item(ItemType.RING, "Ring of shadows"),
        Item(ItemType.POTION, "Potion of wisdom"),
        Item(ItemType.POTION, "Potion of blood"),
        Item(ItemType.WEAPON, "Sword of silver +1"),
        Item(ItemType.POTION, "Potion of rust"),
        Item(ItemType.POTION, "Potion of healing"),
        Item(ItemType.RING, "Ring of armor"),
        Item(ItemType.WEAPON, "Steel halberd"),
        Item(ItemType.WEAPON, "Dagger of poison")
    )

    fun iterator(itemType: ItemType): CustomIterator<Item> {
        return TreasureChestItemIterator(this, itemType)
    }
}

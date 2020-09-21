package dev.shtanko.patterns.behavioral.iterator.list

import dev.shtanko.patterns.behavioral.iterator.CustomIterator

data class TreasureChestItemIterator(
    val chest: TreasureChest,
    val type: ItemType,
    var idx: Int = -1
) : CustomIterator<Item> {

    override fun hasNext(): Boolean {
        return findNextIdx() != -1
    }

    override fun next(): Item? {
        idx = findNextIdx()
        return if (idx != -1) {
            chest.items[idx]
        } else null
    }

    private fun findNextIdx(): Int {
        val items = chest.items
        var tempIdx = idx
        while (true) {
            tempIdx++
            if (tempIdx >= items.size) {
                tempIdx = -1
                break
            }
            if (type == ItemType.ANY || items[tempIdx].type == type) {
                break
            }
        }
        return tempIdx
    }
}

package classes

import java.util.*

class ResourceAccount(id: UUID) {
    private val cards = mutableMapOf<ResourceType, Int>().withDefault { 0 }

    fun add(type: ResourceType, addCount: Int) {
        cards[type] = cards.getValue(type) + addCount
    }

    fun remove(type: ResourceType, removeCount: Int) {
        val oldCount = cards.getValue(type)
        if (oldCount < removeCount) {
            throw Exception("amount of resources to remove is greater than in hand")
        }
        cards[type] = oldCount - removeCount
    }

    fun getCount(type: ResourceType): Int {
        return cards.getValue(type)
    }
}

import java.util.*

class DevelopmentCards(uuid: UUID) {
    private val cards = mutableMapOf<DevelopmentCardType, Int>().withDefault { 0 }
    private val playedCards = mutableMapOf<DevelopmentCardType, Int>().withDefault { 0 }

    fun getCount(cardType: DevelopmentCardType) : Int{
        return cards.getValue(cardType)
    }

    fun add(cardType: DevelopmentCardType) {
        cards[cardType] = cards.getValue(cardType) + 1
    }

    fun play(cardType: DevelopmentCardType) {
        if (cards.getValue(cardType) <= 0) {
            throw Exception("card type does not exist in current deck")
        }
        cards[cardType] = cards.getValue(cardType) - 1
        playedCards[cardType] = cards.getValue(cardType) + 1
    }
}

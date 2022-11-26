import java.util.*

class Player(val name: String, id: UUID) {
    val resources = ResourceAccount(id)
    val developmentCards = DevelopmentCards(id)

}

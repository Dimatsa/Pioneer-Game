import java.util.*

class User(val name: String, id: UUID) {
    val resources = ResourceAccount(id)
    val developmentCards = DevelopmentCards(id)
}

import java.util.*

class User(val name: String, id: String) {
    val resources = ResourceAccount()
    val developmentCards = DevelopmentCards()

    fun getVictoryPoints() : Int {
        return 0
    }
}

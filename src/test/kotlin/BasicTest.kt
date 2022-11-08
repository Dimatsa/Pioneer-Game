import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class BasicTest {
    @Test
    fun testResourceAddRemove() {
        val uuid = UUID.randomUUID()
        val resourceAccount = ResourceAccount(uuid)

        for (type in ResourceType.values()) {
            assertEquals(resourceAccount.getCount(type), 0)
            resourceAccount.add(type, 3)
            assertEquals(resourceAccount.getCount(type), 3)
            resourceAccount.remove(type, 2)
            assertEquals(resourceAccount.getCount(type), 1)
        }
    }

    @Test
    fun testDevelopmentAddRemove() {
        val uuid = UUID.randomUUID()
        val developmentCards = DevelopmentCards(uuid)

        for (type in DevelopmentCardType.values()) {
            assertEquals(developmentCards.getCount(type), 0)
            developmentCards.add(type)
            assertEquals(developmentCards.getCount(type), 1)
            developmentCards.add(type)
            assertEquals(developmentCards.getCount(type), 2)
            developmentCards.play(type)
            assertEquals(developmentCards.getCount(type), 1)
            developmentCards.play(type)
            assertEquals(developmentCards.getCount(type), 0)
        }
    }
}
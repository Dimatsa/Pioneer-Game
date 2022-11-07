import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class UserTest {
    @Test
    fun testReturnTwo() {
        val user = User("Bill", "123")
        assertEquals(user.getVictoryPoints(), 0)
    }
}
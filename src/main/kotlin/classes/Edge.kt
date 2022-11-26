import java.util.*

class Vertex(val coordinates: Pair, id: UUID) {

    val eid: String = id
    val coordinates: Pair = coordinates
    val isOwn: Boolean = true
    val ownName: String = ""

    // might need idk
    val adjVerts = mutableListOf<Vertex>();

}

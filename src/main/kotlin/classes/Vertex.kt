import java.util.*

class Vertex(val coordinates: Triple, id: UUID) {
    val vid: string = id

    val coordinates: Triple = coordinates
    val isOwn: Boolean = true
    val ownName: String = ""

    // might need idk
    val adjEdges = mutableListOf<Edge>();
  }

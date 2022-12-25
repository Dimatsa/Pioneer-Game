package classes

enum class VertexDirections {
    N,
    NE,
    SE,
    S,
    SW,
    NW,
}

enum class EdgeDirections {
    NE,
    E,
    SE,
    SW,
    W,
    NW
}

data class HexCoords(val q: Int, val r: Int) {
    /**
     * Returns the adjacent HexCoords in the provided direction.
     */
    fun getAdjacentCell(direction: EdgeDirections): HexCoords {
        return when (direction) {
            EdgeDirections.NE -> HexCoords(q + 1, r - 1)
            EdgeDirections.E -> HexCoords(q + 1, r)
            EdgeDirections.SE -> HexCoords(q, r + 1)
            EdgeDirections.SW -> HexCoords(q - 1, r + 1)
            EdgeDirections.W -> HexCoords(q - 1, r)
            EdgeDirections.NW -> HexCoords(q, r - 1)
        }
    }

    /**
     * Returns all the vertices of the hex.
     */
    fun getVertices(): Array<VertexCoords> {
        return arrayOf(
            VertexCoords(this, VertexDirections.N),
            VertexCoords(this, VertexDirections.NE),
            VertexCoords(this, VertexDirections.SE),
            VertexCoords(this, VertexDirections.S),
            VertexCoords(this, VertexDirections.SW),
            VertexCoords(this, VertexDirections.NW),
        )
    }
}

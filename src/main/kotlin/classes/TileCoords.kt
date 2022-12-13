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

data class TileCoords(val q: Int, val r: Int) {
    /**
     * Returns the adjacent HexCellCoords in the provided direction.
     * @return adjacent HexCellCoords
     */
    fun getAdjacentCell(direction: EdgeDirections): TileCoords {
        return when (direction) {
            EdgeDirections.NE -> TileCoords(q + 1, r - 1)
            EdgeDirections.E -> TileCoords(q + 1, r)
            EdgeDirections.SE -> TileCoords(q, r + 1)
            EdgeDirections.SW -> TileCoords(q - 1, r + 1)
            EdgeDirections.W -> TileCoords(q - 1, r)
            EdgeDirections.NW -> TileCoords(q, r - 1)
        }
    }

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

package classes

import java.util.Objects.hash

class EdgeCoords(val q: Int, val r: Int, val direction: EdgeDirections) {
    constructor(hexCell: TileCoords, direction: EdgeDirections) : this(hexCell.q, hexCell.r, direction) {}

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is EdgeCoords) {
            return false
        }
        val edge1 = this.normalizedEdge()
        val edge2 = other.normalizedEdge()
        return (edge1.getHexCoords() == edge2.getHexCoords() && edge1.direction == edge2.direction)
    }

    override fun hashCode(): Int {
        val normalized = this.normalizedEdge()
        return hash(normalized.q, normalized.r, normalized.direction)
    }

    /**
     * Normalizes edges, so they can be compared with other edges and used in a hashtable.
     */
    private fun normalizedEdge(): EdgeCoords {
        // Observe that directions are only expressed using SW, W, NW
        return when (direction) {
            EdgeDirections.NE -> EdgeCoords(
                getHexCoords().getAdjacentCell(EdgeDirections.NE),
                EdgeDirections.SW
            )
            EdgeDirections.E -> EdgeCoords(
                getHexCoords().getAdjacentCell(EdgeDirections.E),
                EdgeDirections.W
            )
            EdgeDirections.SE -> EdgeCoords(
                getHexCoords().getAdjacentCell(EdgeDirections.SE),
                EdgeDirections.NW
            )
            else -> this
        }
    }

    /**
     * Returns the vertices at the endpoints of the edge.
     */
    fun getVertices(): List<VertexCoords> {
        val normalized = this.normalizedEdge()
        return when (normalized.direction) {
            EdgeDirections.NW -> listOf(
                VertexCoords(normalized.getHexCoords(), VertexDirections.N),
                VertexCoords(normalized.getHexCoords(), VertexDirections.NW)
            )
            EdgeDirections.W -> listOf(
                VertexCoords(normalized.getHexCoords(), VertexDirections.NW),
                VertexCoords(normalized.getHexCoords(), VertexDirections.SW)
            )
            EdgeDirections.SW -> listOf(
                VertexCoords(normalized.getHexCoords(), VertexDirections.SW),
                VertexCoords(normalized.getHexCoords(), VertexDirections.S)
            )
            else -> throw Exception("Invalid normalized direction.")
        }
    }

    fun getHexCoords(): TileCoords {
        return TileCoords(q, r)
    }
}

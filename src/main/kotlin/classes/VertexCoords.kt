package classes

import java.util.*

class VertexCoords(val q: Int, val r: Int, val direction: VertexDirections) {

    constructor(hexCell: HexCoords, direction: VertexDirections) : this(hexCell.q, hexCell.r, direction) {}

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is VertexCoords) {
            return false
        }
        val vertex1 = this.normalizedVertex()
        val vertex2 = other.normalizedVertex()
        return (vertex1.getHexCoords() == vertex2.getHexCoords() && vertex1.direction == vertex2.direction)
    }

    override fun hashCode(): Int {
        val normalized = this.normalizedVertex()
        return Objects.hash(normalized.q, normalized.r, normalized.direction)
    }

    /**
     * Returns the normalized vertices, so they can be compared with other vertices and used in a hashtable.
     */
    private fun normalizedVertex(): VertexCoords {
        // Observe that directions are only expressed using N and NW
        return when (direction) {
            VertexDirections.NE -> VertexCoords(
                getHexCoords().getAdjacentCell(EdgeDirections.E),
                VertexDirections.NW
            )
            VertexDirections.SE -> VertexCoords(
                getHexCoords().getAdjacentCell(EdgeDirections.SE),
                VertexDirections.N
            )
            VertexDirections.S -> VertexCoords(
                getHexCoords().getAdjacentCell(EdgeDirections.SE),
                VertexDirections.NW
            )
            VertexDirections.SW -> VertexCoords(
                getHexCoords().getAdjacentCell(EdgeDirections.SW),
                VertexDirections.N
            )
            else -> this
        }
    }

    /**
     * Returns the edges joined to the vertex.
     */
    fun getEdges(): List<EdgeCoords> {
        val normalized = this.normalizedVertex()
        return when (normalized.direction) {
            VertexDirections.N -> listOf(
                EdgeCoords(normalized.getHexCoords(), EdgeDirections.NW),
                EdgeCoords(normalized.getHexCoords(), EdgeDirections.NE),
                EdgeCoords(
                    normalized.getHexCoords().getAdjacentCell(EdgeDirections.NE),
                    EdgeDirections.W
                ),
            )
            VertexDirections.NW -> listOf(
                EdgeCoords(normalized.getHexCoords(), EdgeDirections.NW),
                EdgeCoords(normalized.getHexCoords(), EdgeDirections.W),
                EdgeCoords(
                    normalized.getHexCoords().getAdjacentCell(EdgeDirections.NW),
                    EdgeDirections.SW
                ),
            )
            else -> throw Exception("Invalid normalized direction.")
        }
    }

    /**
     * Returns the HexCoords of the root tile.
     */
    fun getHexCoords(): HexCoords {
        return HexCoords(q, r)
    }
}
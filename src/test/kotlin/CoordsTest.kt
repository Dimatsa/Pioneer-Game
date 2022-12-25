import classes.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class CoordsTest {
    @Test
    fun hexCellsAdjacentCells() {
        var currHex = HexCoords(0, 0)
        currHex = currHex.getAdjacentCell(EdgeDirections.NE)
        assertEquals(Pair(1, -1), Pair(currHex.q, currHex.r))
        currHex = currHex.getAdjacentCell(EdgeDirections.SE)
        assertEquals(Pair(1, 0), Pair(currHex.q, currHex.r))
        currHex = currHex.getAdjacentCell(EdgeDirections.SW)
        assertEquals(Pair(0, 1), Pair(currHex.q, currHex.r))
        currHex = currHex.getAdjacentCell(EdgeDirections.W)
        assertEquals(Pair(-1, 1), Pair(currHex.q, currHex.r))
        currHex = currHex.getAdjacentCell(EdgeDirections.NW)
        assertEquals(Pair(-1, 0), Pair(currHex.q, currHex.r))
        currHex = currHex.getAdjacentCell(EdgeDirections.NE)
        assertEquals(Pair(0, -1), Pair(currHex.q, currHex.r))
        currHex = currHex.getAdjacentCell(EdgeDirections.E)
        assertEquals(Pair(1, -1), Pair(currHex.q, currHex.r))
        currHex = currHex.getAdjacentCell(EdgeDirections.SW)
        assertEquals(Pair(0, 0), Pair(currHex.q, currHex.r))
    }

    @Test
    fun vertexEquals() {
        // Compare N, SE, SW
        val v1N = VertexCoords(0, 0, VertexDirections.N)
        val v1SE = VertexCoords(0, -1, VertexDirections.SE)
        val v1SW = VertexCoords(1, -1, VertexDirections.SW)
        assertEquals(v1N, v1SE)
        assertEquals(v1N, v1SW)
        // Compare NW, S, NE
        val v2NW = VertexCoords(0, 0, VertexDirections.NW)
        val v2S = VertexCoords(0, -1, VertexDirections.S)
        val v2NE = VertexCoords(-1, 0, VertexDirections.NE)
        assertEquals(v2NW, v2S)
        assertEquals(v2NW, v2NE)
        assertNotEquals(v1N, v2NE)
    }

    @Test
    fun vertexHashCode() {
        // Compare N, SE, SW
        val v1N = VertexCoords(0, 0, VertexDirections.N)
        val v1SE = VertexCoords(0, -1, VertexDirections.SE)
        val v1SW = VertexCoords(1, -1, VertexDirections.SW)
        assertEquals(v1N.hashCode(), v1SE.hashCode())
        assertEquals(v1N.hashCode(), v1SW.hashCode())
        // Compare NW, S, NE
        val v2NW = VertexCoords(0, 0, VertexDirections.NW)
        val v2S = VertexCoords(0, -1, VertexDirections.S)
        val v2NE = VertexCoords(-1, 0, VertexDirections.NE)
        assertEquals(v2NW.hashCode(), v2S.hashCode())
        assertEquals(v2NW.hashCode(), v2NE.hashCode())
        assertNotEquals(v1N.hashCode(), v2NE.hashCode())
    }

    @Test
    fun edgeEquals() {
        // Compare NW, SE
        val e1NW = EdgeCoords(0, 0, EdgeDirections.NW)
        val e1SE = EdgeCoords(0, -1, EdgeDirections.SE)
        assertEquals(e1NW, e1SE)
        // Compare NE, SW
        val e2NE = EdgeCoords(-1, 0, EdgeDirections.NE)
        val e2SW = EdgeCoords(0, -1, EdgeDirections.SW)
        assertEquals(e2NE, e2SW)
        // Compare E, W
        val e3E = EdgeCoords(-1, 0, EdgeDirections.E)
        val e3W = EdgeCoords(0, 0, EdgeDirections.W)
        assertEquals(e3E, e3W)
        assertNotEquals(e1NW, e2NE)
        assertNotEquals(e1NW, e3E)
    }

    @Test
    fun edgeHashcode() {
        // Compare NW, SE
        val e1NW = EdgeCoords(0, 0, EdgeDirections.NW)
        val e1SE = EdgeCoords(0, -1, EdgeDirections.SE)
        assertEquals(e1NW.hashCode(), e1SE.hashCode())
        // Compare NE, SW
        val e2NE = EdgeCoords(-1, 0, EdgeDirections.NE)
        val e2SW = EdgeCoords(0, -1, EdgeDirections.SW)
        assertEquals(e2NE.hashCode(), e2SW.hashCode())
        // Compare E, W
        val e3E = EdgeCoords(-1, 0, EdgeDirections.E)
        val e3W = EdgeCoords(0, 0, EdgeDirections.W)
        assertEquals(e3E.hashCode(), e3W.hashCode())
        assertNotEquals(e1NW.hashCode(), e2NE.hashCode())
        assertNotEquals(e1NW.hashCode(), e3E.hashCode())
    }

    @Test
    fun edgeGetVertices() {
        val origin = HexCoords(0, 0)
        // NW
        var actual = EdgeCoords(origin, EdgeDirections.NW).getVertices()
        assertContains(actual, VertexCoords(origin, VertexDirections.N))
        assertContains(actual, VertexCoords(origin, VertexDirections.NW))
        // NE
        actual = EdgeCoords(origin, EdgeDirections.NE).getVertices()
        assertContains(actual, VertexCoords(origin, VertexDirections.N))
        assertContains(actual, VertexCoords(origin, VertexDirections.NE))
        // E
        actual = EdgeCoords(origin, EdgeDirections.E).getVertices()
        assertContains(actual, VertexCoords(origin, VertexDirections.NE))
        assertContains(actual, VertexCoords(origin, VertexDirections.SE))
        // SE
        actual = EdgeCoords(origin, EdgeDirections.SE).getVertices()
        assertContains(actual, VertexCoords(origin, VertexDirections.SE))
        assertContains(actual, VertexCoords(origin, VertexDirections.S))
        // SW
        actual = EdgeCoords(origin, EdgeDirections.SW).getVertices()
        assertContains(actual, VertexCoords(origin, VertexDirections.S))
        assertContains(actual, VertexCoords(origin, VertexDirections.SW))
        // W
        actual = EdgeCoords(origin, EdgeDirections.W).getVertices()
        assertContains(actual, VertexCoords(origin, VertexDirections.NW))
        assertContains(actual, VertexCoords(origin, VertexDirections.SW))
    }

    @Test
    fun vertexGetEdges() {
        val origin = HexCoords(0, 0)
        // N
        var actual = VertexCoords(origin, VertexDirections.N).getEdges()
        assertContains(actual, EdgeCoords(origin, EdgeDirections.NW))
        assertContains(actual, EdgeCoords(origin, EdgeDirections.NE))
        assertContains(actual, EdgeCoords(origin.getAdjacentCell(EdgeDirections.NE), EdgeDirections.W))
        // NE
        actual = VertexCoords(origin, VertexDirections.NE).getEdges()
        assertContains(actual, EdgeCoords(origin, EdgeDirections.NE))
        assertContains(actual, EdgeCoords(origin, EdgeDirections.E))
        assertContains(actual, EdgeCoords(origin.getAdjacentCell(EdgeDirections.E), EdgeDirections.NW))
        // SE
        actual = VertexCoords(origin, VertexDirections.SE).getEdges()
        assertContains(actual, EdgeCoords(origin, EdgeDirections.E))
        assertContains(actual, EdgeCoords(origin, EdgeDirections.SE))
        assertContains(actual, EdgeCoords(origin.getAdjacentCell(EdgeDirections.SE), EdgeDirections.NE))
        // S
        actual = VertexCoords(origin, VertexDirections.S).getEdges()
        assertContains(actual, EdgeCoords(origin, EdgeDirections.SE))
        assertContains(actual, EdgeCoords(origin, EdgeDirections.SW))
        assertContains(actual, EdgeCoords(origin.getAdjacentCell(EdgeDirections.SE), EdgeDirections.W))
        // SW
        actual = VertexCoords(origin, VertexDirections.SW).getEdges()
        assertContains(actual, EdgeCoords(origin, EdgeDirections.SW))
        assertContains(actual, EdgeCoords(origin, EdgeDirections.W))
        assertContains(actual, EdgeCoords(origin.getAdjacentCell(EdgeDirections.SW), EdgeDirections.NW))
        // NW
        actual = VertexCoords(origin, VertexDirections.NW).getEdges()
        assertContains(actual, EdgeCoords(origin, EdgeDirections.NW))
        assertContains(actual, EdgeCoords(origin, EdgeDirections.W))
        assertContains(actual, EdgeCoords(origin.getAdjacentCell(EdgeDirections.W), EdgeDirections.NE))
    }
}
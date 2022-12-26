package classes

class GameMap {
    private val roads = mutableMapOf<EdgeCoords, Structure>()
    private val buildings = mutableMapOf<VertexCoords, Building>()

    // Use default map for now
    private val ports = mapOf<EdgeCoords, Port>(
        EdgeCoords(-2, 1, EdgeDirections.W) to Port(ResourceType.CLAY),
        EdgeCoords(-1, -1, EdgeDirections.W) to Port(ResourceType.WOOD),
        EdgeCoords(0, -2, EdgeDirections.NW) to Port(null),
        EdgeCoords(1, -2, EdgeDirections.NE) to Port(ResourceType.SHEEP),
        EdgeCoords(2, -1, EdgeDirections.NE) to Port(ResourceType.ORE),
        EdgeCoords(1, 1, EdgeDirections.SE) to Port(ResourceType.SHEEP),
        EdgeCoords(-1, 2, EdgeDirections.SE) to Port(null),
        EdgeCoords(-2, 2, EdgeDirections.SW) to Port(null),
    )
    private val hexTiles: Map<HexCoords, HexTile> = mapOf<HexCoords, HexTile>(
        // Center
        HexCoords(0, 0) to HexTile(TileType.DESERT, 0),
        // First Ring
        HexCoords(1, -1) to HexTile(TileType.PASTURE, 4),
        HexCoords(1, 0) to HexTile(TileType.FOREST, 3),
        HexCoords(0, 1) to HexTile(TileType.FIELD, 4),
        HexCoords(-1, 1) to HexTile(TileType.MOUNTAIN, 3),
        HexCoords(-1, 0) to HexTile(TileType.FOREST, 11),
        HexCoords(0, -1) to HexTile(TileType.HILL, 6),
        // Second Ring
        HexCoords(1, -2) to HexTile(TileType.PASTURE, 2),
        HexCoords(2, -2) to HexTile(TileType.FOREST, 9),
        HexCoords(2, -1) to HexTile(TileType.HILL, 10),
        HexCoords(2, 0) to HexTile(TileType.MOUNTAIN, 8),
        HexCoords(1, 1) to HexTile(TileType.PASTURE, 5),
        HexCoords(0, 2) to HexTile(TileType.PASTURE, 11),
        HexCoords(-1, 2) to HexTile(TileType.FIELD, 6),
        HexCoords(-2, 2) to HexTile(TileType.HILL, 5),
        HexCoords(-2, 1) to HexTile(TileType.FOREST, 8),
        HexCoords(-2, 0) to HexTile(TileType.FIELD, 9),
        HexCoords(-1, -1) to HexTile(TileType.FIELD, 12),
        HexCoords(0, -2) to HexTile(TileType.MOUNTAIN, 10),
    )
}
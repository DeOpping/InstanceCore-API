package io.github.deopping.instancecore.api.schematic

data class BlockPosition(
    val x: Int,
    val y: Int,
    val z: Int
) {

    operator fun plus(other: BlockPosition): BlockPosition {
        return BlockPosition(
            x = x + other.x,
            y = y + other.y,
            z = z + other.z
        )
    }

    operator fun minus(other: BlockPosition): BlockPosition {
        return BlockPosition(
            x = x - other.x,
            y = y - other.y,
            z = z - other.z
        )
    }

}

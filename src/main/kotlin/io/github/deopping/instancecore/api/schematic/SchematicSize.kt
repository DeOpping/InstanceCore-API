package io.github.deopping.instancecore.api.schematic

data class SchematicSize(
    val x: Int,
    val y: Int,
    val z: Int
) {

    init {
        require(x >= 0) { "x must be >= 0" }
        require(y >= 0) { "y must be >= 0" }
        require(z >= 0) { "z must be >= 0" }
    }

    val volume: Long
        get() = x.toLong() * y * z

}

package io.github.deopping.instancecore.api.schematic

interface Schematic {

    val size: SchematicSize

    fun getBlock(position: BlockPosition): SchematicBlock?

    fun blocks(): Sequence<SchematicBlock>

}
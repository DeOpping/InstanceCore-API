package io.github.deopping.instancecore.api.schematic

import org.bukkit.block.data.BlockData

data class SchematicBlock(
    val position: BlockPosition,
    val data: BlockData
)

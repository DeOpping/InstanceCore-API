package io.github.deopping.instancecore.api.schematic.nbt

interface VarIntReader {

    fun read(): Int

    fun finished(): Boolean

}
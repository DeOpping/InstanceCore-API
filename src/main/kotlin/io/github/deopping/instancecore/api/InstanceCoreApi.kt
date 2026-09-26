package io.github.deopping.instancecore.api

import io.github.deopping.instancecore.api.instance.InstanceManager
import io.github.deopping.instancecore.api.schematic.SchematicManager
import io.github.deopping.instancecore.api.schematic.nbt.NbtReader
import io.github.deopping.instancecore.api.schematic.nbt.VarIntReader
import java.io.InputStream

interface InstanceCoreApi {

    val instances: InstanceManager

    val schematics: SchematicManager

    /**
     * @return an implementation of the NbtReader.
     */
    fun createNbtReader(inputStream: InputStream): NbtReader

    /**
     * @return an implementation of the VarIntReader.
     */
    fun createVarIntReader(data: ByteArray): VarIntReader

    /**
     * Shuts down the API and releases all runtime sources.
     */
    fun shutdown()

}
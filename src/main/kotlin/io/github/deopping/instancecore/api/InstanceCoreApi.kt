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
     * Creates an InstanceCore-provided [NbtReader] for the supplied input.
     *
     * The returned reader is forward-only and reads directly from the
     * supplied stream. The caller is responsible for managing the lifetime
     * of the supplied [InputStream]
     *
     * This method is intended for extensions such as custom schematic
     * loaders that need to parse NBT without depending on InstanceCore's
     * internal NBT implementation.
     *
     * @param inputStream input containing NBT data.
     * @return an InstanceCore-provided [NbtReader]
     */
    fun createNbtReader(inputStream: InputStream): NbtReader

    /**
     * Creates an InstanceCore-provided [VarIntReader] for the supplied data.
     *
     * The returned reader is forward-only and starts at the beginning of the
     * supplied byte array.
     *
     * This method is intended for extensions such as custom schematic
     * loaders that use VarInt-encoded data.
     *
     * @param data encoded VarInt data.
     * @return an InstanceCore-provided [VarIntReader]
     */
    fun createVarIntReader(data: ByteArray): VarIntReader

    /**
     * Shuts down the API and releases all runtime resources owned by InstanceCore.
     *
     * After shutdown, previously created runtime objects should no longer be used
     * unless explicitly documented otherwise.
     *
     * Called automatically when the InstanceCore plugin is disabled.
     */
    fun shutdown()

}
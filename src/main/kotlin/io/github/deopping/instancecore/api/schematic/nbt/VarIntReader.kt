package io.github.deopping.instancecore.api.schematic.nbt

import io.github.deopping.instancecore.api.InstanceCoreApi

/**
 * Reads a sequence of variable-length integers.
 *
 * Implementations are provided by InstanceCore and should generally not be
 * constructed directly by API consumers. Obtain an implementation through
 * [InstanceCoreApi.createVarIntReader].
 *
 * The reader is forward-only. Each call to [read] consumes the next VarInt
 * from the underlying data.
 *
 * This interface is particularly useful for schematic formats such as
 * Sponge v3, whose block data is represented as a sequence of VarInts.
 */
interface VarIntReader {

    /**
     * Reads the next VarInt.
     *
     * @return the decoded integer.
     * @throws NbtReadException if the underlying data is malformed or ends
     * unexpectedly while reading the VarInt.
     */
    fun read(): Int

    /**
     * Returns whether all input data has been consumed.
     *
     * @return `true` when no unread bytes remain, otherwise `false`.
     */
    fun finished(): Boolean

}
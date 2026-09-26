package io.github.deopping.instancecore.api.schematic.nbt

import io.github.deopping.instancecore.api.InstanceCoreApi

/**
 * Reads an uncompressed NBT stream.
 *
 * Implementations are provided by InstanceCore and should generally not be
 * constructed directly by API consumers. Obtain an implementation through
 * [InstanceCoreApi.createNbtReader].
 *
 * The reader operates directly on the supplied input and does not expose
 * the entire NBT structure as an in-memory object tree. This allows large
 * NBT-based formats to be processed with significantly less intermediate
 * memory usage.
 *
 * NBT compound and list payloads may be skipped with [skipPayload] when a
 * caller does not need their contents.
 *
 * Implementations may consume the underlying input while reading or skipping
 * data. Callers should therefore treat the reader as a forward-only reader.
 */
interface NbtReader {

    /**
     * Reads the root NBT tag and expects it to be a [NbtTagType.COMPOUND].
     *
     * The root tag's name is consumed automatically. The supplied action is
     * invoked with this reader positioned at the root compound's payload.
     *
     * @param action receives this reader while reading the root compound.
     * @throws NbtReadException if the root tag is not a compound or the input
     * cannot be read as valid NBT.
     */
    fun readRootCompound(action: (NbtReader) -> Unit)

    /**
     * Reads the contents of an NBT compound.
     *
     * The action is invoked once for each entry in the compound. Returning
     * `true` stops reading the current compound immediately. This can be used
     * when a caller has found all information it needs and does not need to
     * consume the remainder of the compound.
     *
     * The reader supplied to the action is the same reader used to read
     * the compound payload and is positioned immediately after the entry's name.
     *
     * @param action handles each compound entry.
     * @throws NbtReadException if the compound contains invalid NBT data.
     */
    fun readCompound(
        action: (
            type: NbtTagType,
            name: String,
            reader: NbtReader
        ) -> Boolean
    )

    fun readByte():     Byte
    fun readShort():    Short
    fun readInt():      Int
    fun readLong():     Long
    fun readFloat():    Float
    fun readDouble():   Double
    fun readString():   String
    fun readByteArray(): ByteArray
    fun readIntArray(): IntArray
    fun readLongArray(): LongArray

    /**
     * Skips an NBT payload of the specified type without materializing it.
     *
     * This is useful when a format contains data that is not required by the
     * caller, such as optional metadata, entities, or block entities.
     *
     * @param type the type of the payload to skip.
     * @throws NbtReadException if the payload cannot be skipped or is invalid.
     */
    fun skipPayload(type: NbtTagType)

}
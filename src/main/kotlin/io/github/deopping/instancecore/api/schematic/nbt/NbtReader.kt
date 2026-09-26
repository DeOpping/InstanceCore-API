package io.github.deopping.instancecore.api.schematic.nbt

interface NbtReader {

    fun readRootCompound(action: (NbtReader) -> Unit)

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

    fun skipPayload(type: NbtTagType)

}
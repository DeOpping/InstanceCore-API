package io.github.deopping.instancecore.api.schematic.nbt

enum class NbtTagType(
    val id: Int
) {

    END(0),
    BYTE(1),
    SHORT(2),
    INT(3),
    LONG(4),
    FLOAT(5),
    DOUBLE(6),
    BYTE_ARRAY(7),
    STRING(8),
    LIST(9),
    COMPOUND(10),
    INT_ARRAY(11),
    LONG_ARRAY(12);

    companion object {
        fun fromId(id: Int): NbtTagType {
            return entries.firstOrNull { it.id == id }
                ?: throw NbtReadException(
                   "Unknown NBT tag type: $id"
                )
        }
    }

}
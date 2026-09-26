package io.github.deopping.instancecore.api.schematic.nbt

/**
 * Identifies the type of NBT tag.
 *
 * Each type has a numeric ID defined by the NBT binary format. The IDs are
 * part of the serialized format and must not be changed.
 */
enum class NbtTagType(
    val id: Int
) {

    /** Marks the end of an NBT compound. */
    END(0),
    /** A signed 8-bit integer. */
    BYTE(1),
    /** A signed 16-bit integer. */
    SHORT(2),
    /** A signed 32-bit integer. */
    INT(3),
    /** A signed 64-bit integer. */
    LONG(4),
    /** A 32-bit IEEE-754 floating-point value. */
    FLOAT(5),
    /** A 64-bit IEEE-754 floating-point value. */
    DOUBLE(6),
    /** An array of bytes. */
    BYTE_ARRAY(7),
    /** A UTF-8 string. */
    STRING(8),
    /** A sequence of values sharing a single element type. */
    LIST(9),
    /** A collection of named NBT tags. */
    COMPOUND(10),
    /** An array of 32-bit integers. */
    INT_ARRAY(11),
    /** An array of 64-bit integers. */
    LONG_ARRAY(12);

    companion object {
        /**
         * Resolves an NBT tag type from its serialized numeric ID.
         *
         * @param id numeric NBT tag ID.
         * @return the corresponding [NbtTagType]
         * @throws NbtReadException if the ID is not defined by the NBT format.
         */
        fun fromId(id: Int): NbtTagType {
            return entries.firstOrNull { it.id == id }
                ?: throw NbtReadException(
                   "Unknown NBT tag type: $id"
                )
        }
    }

}
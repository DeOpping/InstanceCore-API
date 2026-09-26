package io.github.deopping.instancecore.api.schematic.nbt

/**
 * Thrown when NBT data cannot be read because it is malformed, incomplete,
 * or otherwise invalid for the operation being performed.
 *
 * This exception is unchecked so schematic and NBT readers do not require callers
 * to catch or declare it when working with malformed input.
 */
class NbtReadException : RuntimeException {

    constructor(message: String, throwable: Throwable?) : super(message, throwable)
    constructor(message: String) : super(message)
    constructor(throwable: Throwable) : super(throwable)

}
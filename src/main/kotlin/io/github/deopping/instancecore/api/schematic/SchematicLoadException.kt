package io.github.deopping.instancecore.api.schematic

class SchematicLoadException : RuntimeException {

    constructor(message: String, throwable: Throwable?) : super(message, throwable)
    constructor(message: String) : super(message)
    constructor(throwable: Throwable) : super(throwable)

}
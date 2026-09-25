package io.github.deopping.instancecore.api.schematic

import java.io.InputStream

interface SchematicLoader {

    fun load(input: InputStream): Schematic

}
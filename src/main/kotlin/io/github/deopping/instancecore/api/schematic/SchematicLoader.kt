package io.github.deopping.instancecore.api.schematic

import java.io.InputStream

interface SchematicLoader {

    /**
     * Stable identifier for this schematic format.
     *
     * Example: "sponge-v3"
     */
    val id: String

    /**
     * The input may be consumed. The caller is responsible
     * for providing a fresh stream when loading.
     *
     * @return `true` if this input represents a schematic
     * understood by this loader, `false` otherwise.
     */
    fun isFormat(input: InputStream): Boolean

    /**
     * Loads a schematic from the input.
     *
     * The input is positioned at the beginning of the file.
     */
    fun load(input: InputStream): Schematic

}
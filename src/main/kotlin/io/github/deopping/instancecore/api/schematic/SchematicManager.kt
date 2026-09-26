package io.github.deopping.instancecore.api.schematic

import org.bukkit.NamespacedKey
import java.nio.file.Path

interface SchematicManager {

    /**
     * @return the previously registered schematic or `null`.
     */
    fun get(key: NamespacedKey): Schematic?

    /**
     * Registers a schematic if the key was not used previously.
     * @return `true` if the schematic was registered, `false` otherwise
     */
    fun register(
        key: NamespacedKey,
        schematic: Schematic
    ): Boolean

    /**
     * Removes a schematic.
     * @return the removed schematic, or `null` if none existed.
     */
    fun unregister(key: NamespacedKey): Schematic?

    /**
     * Returns all currently registered schematic keys.
     */
    fun keys(): Set<NamespacedKey>

    /**
     * Automatically detects the schematic format and loads it.
     */
    fun load(file: Path): Schematic

    /**
     * Registers a schematic format loader.
     * @return `true` if the loader was registered, `false` otherwise.
     */
    fun registerLoader(loader: SchematicLoader): Boolean

    /**
     * Removes a schematic format loader by its ID.
     * @return the removed loader, or `null`.
     */
    fun unregisterLoader(id: String): SchematicLoader?

    /**
     * @return all currently registered schematic loaders.
     */
    fun loaders(): Collection<SchematicLoader>

}
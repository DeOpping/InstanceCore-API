package io.github.deopping.instancecore.api.schematic

import org.bukkit.NamespacedKey

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

}
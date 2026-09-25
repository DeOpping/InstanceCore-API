package io.github.deopping.instancecore.api.instance

import io.github.deopping.instancecore.api.schematic.Schematic
import org.bukkit.World
import java.util.UUID

interface InstanceManager {

    /**
     * Creates a new player group.
     * @return the created instance group.
     */
    fun createGroup(): InstanceGroup

    /**
     * Creates and optionally starts a virtual instance.
     * @return the created instance.
     */
    fun createInstance(
        schematic: Schematic,
        world: World,
        x: Int,
        y: Int,
        z: Int,
        group: InstanceGroup,
        active: Boolean = true
    ): Instance

    /**
     * Finds an instance by ID.
     * @return the instance or `null`.
     */
    fun get(id: UUID): Instance?

    /**
     * @return all currently active instances.
     */
    fun instances(): Collection<Instance>

    /**
     * Removes and destroys an instance.
     * @return `true` if an instance was removed, `false` if it did not exist.
     */
    fun remove(id: UUID): Boolean

}
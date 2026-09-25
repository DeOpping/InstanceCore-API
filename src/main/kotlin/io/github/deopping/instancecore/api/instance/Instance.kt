package io.github.deopping.instancecore.api.instance

import io.github.deopping.instancecore.api.schematic.Schematic
import org.bukkit.World
import java.util.UUID

interface Instance : AutoCloseable {

    /**
     * Unique runtime identifier for this instance.
     */
    val id: UUID

    /**
     * The schematic backing this instance.
     */
    val schematic: Schematic

    /**
     * The world in which this instance is rendered.
     */
    val world: World

    /** The minimum block X coordinate of the instance in the real world. */
    val x: Int
    /** The minimum block Y coordinate of the instance in the real world. */
    val y: Int
    /** The minimum block Z coordinate of the instance in the real world. */
    val z: Int

    /**
     * The player group that can see this instance.
     */
    val group: InstanceGroup

    /**
     * Whether this instance is currently rendered.
     */
    val isActive: Boolean

    /**
     * Starts rendering the instance to its group.
     */
    fun show()

    /**
     * Stops rendering the instance to its group.
     */
    fun hide()

    /**
     * Rebuilds and resends the instance to its group.
     */
    fun refresh()

    /**
     * Permanently destroys this instance.
     */
    override fun close()

}
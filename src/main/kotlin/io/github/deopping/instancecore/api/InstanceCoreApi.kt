package io.github.deopping.instancecore.api

import io.github.deopping.instancecore.api.instance.InstanceManager
import io.github.deopping.instancecore.api.schematic.SchematicManager

interface InstanceCoreApi {

    val instances: InstanceManager

    val schematics: SchematicManager

    /**
     * Shuts down the API and releases all runtime sources.
     */
    fun shutdown()

}
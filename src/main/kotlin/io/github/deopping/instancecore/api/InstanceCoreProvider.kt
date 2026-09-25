package io.github.deopping.instancecore.api

import org.bukkit.Bukkit

object InstanceCoreProvider {

    /**
     * @return the currently registered InstanceCore API,
     * or `null` if InstanceCore is unavailable.
     */
    fun get(): InstanceCoreApi? {
        return Bukkit.getServicesManager()
            .load(InstanceCoreApi::class.java)
    }

}
package io.github.deopping.instancecore.api.instance

import java.util.UUID

interface InstanceGroup {

    val id: UUID

    /**
     * Players currently belonging to this group.
     */
    val players: Set<UUID>

    fun playerCount(): Int

    fun addPlayer(playerId: UUID): Boolean

    fun removePlayer(playerId: UUID): Boolean

    fun contains(playerId: UUID): Boolean

    /**
     * Clears the set of players in this instance group.
     * @return `true` if players were removed, `false` if the players set was already empty
     */
    fun clear(): Boolean

}
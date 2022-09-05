package com.vjh0107.penetrator.events

import com.vjh0107.penetrator.data.ProjectileData
import org.bukkit.entity.Trident
import org.bukkit.event.entity.EntityDamageByEntityEvent

class TridentDamageEvent(
    val trident: Trident,
    val projectileData: ProjectileData,
    delegated: EntityDamageByEntityEvent
) : EntityDamageByEntityEvent(
    trident,
    delegated.entity,
    delegated.cause,
    delegated.damage
)
package com.vjh0107.penetrator.events

import org.bukkit.entity.Trident
import org.bukkit.event.entity.ProjectileLaunchEvent

/**
 * Trident 가 발사되면 호출되는 이벤트입니다.
 *
 * @param trident 삼지창
 */
class TridentLaunchEvent(val trident: Trident) : ProjectileLaunchEvent(trident)
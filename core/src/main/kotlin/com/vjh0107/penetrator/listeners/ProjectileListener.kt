package com.vjh0107.penetrator.listeners

import com.vjh0107.barcode.framework.component.BarcodeComponent
import com.vjh0107.barcode.framework.component.listener.BarcodeListener
import com.vjh0107.penetrator.events.TridentLaunchEvent
import org.bukkit.Bukkit
import org.bukkit.entity.Trident
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.ProjectileLaunchEvent

@BarcodeComponent
class ProjectileListener : BarcodeListener {
    @EventHandler
    fun onProjectileLaunch(event: ProjectileLaunchEvent) {
        val mayTrident = event.entity
        if (mayTrident is Trident) {
            val tridentLaunchEvent = TridentLaunchEvent(mayTrident)
            Bukkit.getPluginManager().callEvent(tridentLaunchEvent)
        }
    }
}
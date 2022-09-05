package com.vjh0107.penetrator.listeners

import com.vjh0107.barcode.framework.AbstractBarcodePlugin
import com.vjh0107.barcode.framework.component.BarcodeComponent
import com.vjh0107.barcode.framework.component.listener.BarcodeListener
import com.vjh0107.barcode.framework.serialization.deserialize
import com.vjh0107.penetrator.data.ProjectileData
import com.vjh0107.penetrator.events.TridentLaunchEvent
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import com.vjh0107.barcode.framework.serialization.serialize
import com.vjh0107.penetrator.data.NamespacedKeyWrapper
import com.vjh0107.penetrator.events.TridentDamageEvent
import org.bukkit.Bukkit
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Trident
import org.bukkit.event.entity.EntityDamageByEntityEvent

@BarcodeComponent
class TridentListener(private val plugin: AbstractBarcodePlugin) : BarcodeListener {
    companion object {
        const val CONFIG_TRIDENT_MODIFIER_BASE = "trident-modifier.base"
        const val CONFIG_TRIDENT_MODIFIER_PER = "trident-modifier.per"
    }

    @EventHandler
    fun onLaunchTrident(event: TridentLaunchEvent) {
        val mayPlayer = event.entity.shooter
        if (mayPlayer is Player) {
            val trident = event.trident
            trident.isCustomNameVisible = false
            val enchantmentData = mayPlayer
                .inventory
                .itemInMainHand
                .enchantments
                .map { NamespacedKeyWrapper.of(it.key.key) to it.value }
                .toMap()
            val serializedTridentData = ProjectileData.of(
                    trident.uniqueId,
                    mayPlayer.uniqueId,
                    enchantmentData
                ).serialize()
            trident.customName = serializedTridentData
        }
    }

    @EventHandler
    fun onDamage(event: EntityDamageByEntityEvent) {
        val mayTrident = event.damager
        if (mayTrident is Trident) {
            val mayPlayer = mayTrident.shooter
            if (mayPlayer is Player) {
                val deserializedData = mayTrident.customName?.deserialize<ProjectileData>() ?: return
                val tridentDamageEvent = TridentDamageEvent(mayTrident, deserializedData, event)
                Bukkit.getPluginManager().callEvent(tridentDamageEvent)
            }
        }
    }

    @EventHandler
    fun onTridentDamage(event: TridentDamageEvent) {
        val impalingLevel = event.projectileData.getEnchantmentLevel(Enchantment.IMPALING) ?: 0
        val base = plugin.config.getDouble(CONFIG_TRIDENT_MODIFIER_BASE, 1.25)
        val per = plugin.config.getDouble(CONFIG_TRIDENT_MODIFIER_PER, 0.15) * impalingLevel
        event.damage = event.damage * (base + per)
    }
}
package com.vjh0107.penetrator.managers

import com.vjh0107.barcode.framework.AbstractBarcodePlugin
import com.vjh0107.barcode.framework.component.BarcodeComponent
import com.vjh0107.barcode.framework.component.manager.Reloadable

@BarcodeComponent
class ConfigManager(private val plugin: AbstractBarcodePlugin) : Reloadable {
    override fun load() {
        plugin.reloadConfig()
        plugin.server.broadcastMessage("[Penetration] Reloading Complete")
    }

    override fun close() {
        plugin.server.broadcastMessage("[Penetration] Reloading...")
    }
}
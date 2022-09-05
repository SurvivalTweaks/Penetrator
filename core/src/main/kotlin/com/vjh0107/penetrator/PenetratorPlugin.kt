package com.vjh0107.penetrator

import com.vjh0107.barcode.framework.AbstractBarcodePlugin

class PenetratorPlugin : AbstractBarcodePlugin() {
    override fun enable() {
        saveDefaultConfig()
    }
}
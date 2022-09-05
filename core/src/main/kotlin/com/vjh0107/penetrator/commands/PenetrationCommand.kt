package com.vjh0107.penetrator.commands

import com.vjh0107.barcode.framework.AbstractBarcodePlugin
import com.vjh0107.barcode.framework.component.BarcodeComponent
import com.vjh0107.barcode.framework.component.command.BarcodeCommand
import com.vjh0107.barcode.framework.utils.CommandAPIExtensions.commandAPICommandOf
import com.vjh0107.barcode.framework.utils.CommandAPIExtensions.withSubcommandOf
import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.CommandPermission
import dev.jorel.commandapi.executors.CommandExecutor

@BarcodeComponent
class PenetrationCommand(private val plugin: AbstractBarcodePlugin) : BarcodeCommand {
    override val command: CommandAPICommand = commandAPICommandOf("penetration") {
        withPermission(CommandPermission.OP)
        withAliases("penet")
        withSubcommandOf("reload") {
            executes(CommandExecutor { _, _ ->
                plugin.reloadPlugin()
            })
        }
    }
}
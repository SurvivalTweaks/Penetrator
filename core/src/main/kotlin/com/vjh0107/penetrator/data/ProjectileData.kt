package com.vjh0107.penetrator.data

import com.vjh0107.barcode.framework.serialization.SerializableData
import com.vjh0107.barcode.framework.serialization.serializers.UUIDSerializer
import kotlinx.serialization.Serializable
import org.bukkit.Bukkit
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import java.util.*

@Serializable
data class ProjectileData private constructor(
    @Serializable(with = UUIDSerializer::class) val uuid: UUID,
    @Serializable(with = UUIDSerializer::class) val owner: UUID,
    val enchantmentData: Map<NamespacedKeyWrapper, Int>
) : SerializableData {
    companion object {
        fun of(uuid: UUID, owner: UUID, enchantmentData: Map<NamespacedKeyWrapper, Int>): ProjectileData {
            return ProjectileData(uuid, owner, enchantmentData)
        }
    }

    fun getOwner(): Player {
        return Bukkit.getPlayer(owner) ?: throw NullPointerException("플레이어를 찾을 수 없습니다.")
    }

    fun getEnchantmentLevel(enchantment: Enchantment): Int? {
        return enchantmentData[NamespacedKeyWrapper.of(enchantment.key)]
    }
}
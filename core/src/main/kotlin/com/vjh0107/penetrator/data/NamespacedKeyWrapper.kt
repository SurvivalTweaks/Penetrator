package com.vjh0107.penetrator.data

import com.vjh0107.barcode.framework.serialization.SerializableData
import kotlinx.serialization.Serializable
import org.bukkit.NamespacedKey

@Serializable
data class NamespacedKeyWrapper private constructor (
    val namespace: String,
    val key: String
) : SerializableData {
    companion object {
        fun of(namespacedKey: NamespacedKey): NamespacedKeyWrapper {
            return NamespacedKeyWrapper(namespacedKey.namespace, namespacedKey.key)
        }
    }
}
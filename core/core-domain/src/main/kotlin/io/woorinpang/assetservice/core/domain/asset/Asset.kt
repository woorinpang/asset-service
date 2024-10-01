package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.AssetEntity

data class Asset(
    val id: Long?,
    val userId: Long,
    val type: AssetType,
) {
    companion object {
        fun of(entity: AssetEntity): Asset =
            Asset(
                id = entity.id,
                userId = entity.userId,
                type = AssetType.valueOf(entity.type),
            )
    }
}

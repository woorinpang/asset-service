package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.core.enums.AssetType

interface AssetRepository {
    fun append(userId: Long, type: AssetType, createdBy: Long): Long

    fun findAsset(assetId: Long): Asset?

    fun removeAsset(assetId: Long, updatedBy: Long)

    fun existsByUserIdAndType(id: Long, type: AssetType): Boolean
}

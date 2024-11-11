package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.core.enums.AssetType

interface AssetRepository {
    fun append(userId: Long, type: AssetType, email: String): Long

    fun findAsset(assetId: Long): Asset?

    fun removeAsset(assetId: Long, user: User)

    fun existsByUserIdAndType(id: Long, name: AssetType): Boolean
}

package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.Asset
import io.woorinpang.assetservice.storage.db.core.asset.AssetRepository
import org.springframework.stereotype.Component

@Component
class AssetAppender(
    val assetRepository: AssetRepository,
) {
    fun append(assetType: AssetType): Long? {
        return assetRepository.save(Asset(userId = 1L, type = assetType)).id
    }
}

package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.AssetRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetModifier(
    val assetRepository: AssetRepository,
) {
    @Transactional
    fun modify(assetId: Long, assetType: String) {
        AssetRepositoryHelper
            .findAssetById(assetRepository, assetId)
            .modify(AssetType.valueOf(assetType))
    }
}

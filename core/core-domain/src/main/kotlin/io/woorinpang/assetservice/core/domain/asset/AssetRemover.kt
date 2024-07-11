package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.AssetRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetRemover(
    val assetRepository: AssetRepository
) {
    @Transactional
    fun remove(assetId: Long) {
        AssetRepositoryHelper
            .findAssetById(assetRepository, assetId)
            .delete()
    }
}

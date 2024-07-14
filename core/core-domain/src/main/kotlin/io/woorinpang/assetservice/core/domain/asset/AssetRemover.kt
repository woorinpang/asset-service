package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.AssetJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetRemover(
    val assetJpaRepository: AssetJpaRepository
) {
    @Transactional
    fun remove(assetId: Long) {
        AssetRepositoryHelper.findAssetById(assetJpaRepository, assetId).delete()
    }
}

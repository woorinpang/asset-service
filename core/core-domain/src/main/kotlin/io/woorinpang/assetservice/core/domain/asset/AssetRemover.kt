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
        assetRepository
            .findById(assetId)
            .orElseThrow { IllegalArgumentException("Invalid asset id: $assetId") }
            .delete()
    }
}

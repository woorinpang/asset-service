package io.woorinpang.assetservice.core.domain.asset

import org.springframework.stereotype.Component

@Component
class AssetAppender(
    val assetRepository: AssetRepository,
) {
    fun append(assetType : AssetType) : Long? {
        return assetRepository.save(Asset(userId = 1L, type = assetType)).id
    }
}
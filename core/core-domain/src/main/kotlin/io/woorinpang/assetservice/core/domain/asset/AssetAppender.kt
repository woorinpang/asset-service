package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.AssetType
import org.springframework.stereotype.Component

@Component
class AssetAppender(
    val assetRepository: AssetRepository,
) {
    fun append(assetName : String) : Long? {
        return assetRepository.save(Asset(userId = 1L, name = assetName, type = AssetType.ELECTRONIC)).id
    }
}
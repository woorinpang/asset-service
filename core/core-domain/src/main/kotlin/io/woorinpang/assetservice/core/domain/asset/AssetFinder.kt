package io.woorinpang.assetservice.core.domain.asset

import org.springframework.stereotype.Component

@Component
class AssetFinder(
    val assetRepository: AssetRepository,
) {
    fun find(target: AssetTarget): Asset = AssetHelper.findAssetById(assetRepository, target.id)
}

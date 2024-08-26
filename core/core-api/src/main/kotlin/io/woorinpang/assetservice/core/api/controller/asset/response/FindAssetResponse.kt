package io.woorinpang.assetservice.core.api.controller.asset.response

import io.woorinpang.assetservice.core.domain.asset.Asset

data class FindAssetResponse(
    val assetId: Long?,
    val userId: Long,
    val assetType: String,
    val assetTypeDescription: String,
) {
    companion object {
        fun of(asset: Asset): FindAssetResponse {
            return FindAssetResponse(
                assetId = asset.id,
                userId = asset.userId,
                assetType = asset.type.code,
                assetTypeDescription = asset.type.description,
            )
        }
    }
}
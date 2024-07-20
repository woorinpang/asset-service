package io.woorinpang.assetservice.core.api.controller.asset.request

import io.woorinpang.assetservice.core.api.support.error.ApiErrorType
import io.woorinpang.assetservice.core.api.support.error.CoreApiException
import io.woorinpang.assetservice.core.domain.asset.AssetType

data class AppendAssetRequest(
    val assetType: String,
) {
    fun toAssetType(): AssetType {
        return AssetType.findByCode(assetType) ?: throw CoreApiException(ApiErrorType.INVALID_ASSET_TYPE)
    }
}

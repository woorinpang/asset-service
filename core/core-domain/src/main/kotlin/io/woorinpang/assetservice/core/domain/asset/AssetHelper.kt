package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.support.error.CoreDomainException
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorType

object AssetHelper {
    fun findAssetById(repository: AssetRepository, assetId: Long): Asset {
        return repository.findAsset(assetId) ?: throw CoreDomainException(DomainErrorType.ASSET_NOT_FOUND)
    }
}

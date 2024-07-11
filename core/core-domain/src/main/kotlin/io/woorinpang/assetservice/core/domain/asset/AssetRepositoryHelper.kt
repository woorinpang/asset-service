package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.support.error.CoreDomainException
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorType
import io.woorinpang.assetservice.storage.db.core.asset.Asset
import io.woorinpang.assetservice.storage.db.core.asset.AssetRepository

object AssetRepositoryHelper {
    fun findAssetById(repository: AssetRepository, assetId: Long): Asset {
        return repository
            .findById(assetId)
            .orElseThrow({ CoreDomainException(DomainErrorType.ASSET_NOT_FOUND) })
    }
}
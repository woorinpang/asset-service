package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.support.error.CoreDomainException
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorType
import io.woorinpang.assetservice.storage.db.core.asset.AssetEntity
import io.woorinpang.assetservice.storage.db.core.asset.AssetEntityJpaRepository

object AssetHelper {
    fun findAssetById(repository: AssetEntityJpaRepository, userId: Long): AssetEntity {
        return repository
            .findById(userId)
            .orElseThrow { CoreDomainException(DomainErrorType.ASSET_NOT_FOUND) }
    }
}
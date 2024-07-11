package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.Asset
import org.springframework.stereotype.Service

@Service
class AssetService(
    val assetAppender: AssetAppender,
    val assetFinder: AssetFinder,
    val assetRemover: AssetRemover,
    val assetModifier: AssetModifier,
) {
    fun appendAsset(assetType: String): Long {
        AssetType.findByCode(assetType)?.let {
            return assetAppender.append(it)
        }
        throw IllegalArgumentException("Invalid asset type: $assetType")
    }

    fun findAsset(assetId: Long): Asset {
        return assetFinder.find(assetId)
    }

    fun modifyAsset(assetId: Long, assetType: String) {
        assetModifier.modify(assetId, assetType)
    }

    fun deleteAsset(assetId: Long): Any {
        return assetRemover.remove(assetId)
    }
}

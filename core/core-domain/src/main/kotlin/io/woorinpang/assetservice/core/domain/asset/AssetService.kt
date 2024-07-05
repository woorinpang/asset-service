package io.woorinpang.assetservice.core.domain.asset

import org.springframework.stereotype.Service

@Service
class AssetService(
    val assetAppender: AssetAppender
) {
    fun appendAsset(assetType : String) : Long? {
        AssetType.findByCode(assetType)?.let {
            return assetAppender.append(it)
        }
        throw IllegalArgumentException("Invalid asset type: $assetType")
    }
}
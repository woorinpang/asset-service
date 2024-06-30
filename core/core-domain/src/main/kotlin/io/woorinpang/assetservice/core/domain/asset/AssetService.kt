package io.woorinpang.assetservice.core.domain.asset

import org.springframework.stereotype.Service

@Service
class AssetService(
    val assetAppender: AssetAppender
) {
    fun appendAsset(assetName : String) : Long? {
        return assetAppender.append(assetName)
    }
}
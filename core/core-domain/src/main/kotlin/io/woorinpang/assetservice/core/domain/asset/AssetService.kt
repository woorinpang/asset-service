package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.user.User
import org.springframework.stereotype.Service

@Service
class AssetService(
    val assetAppender: AssetAppender,
    val assetFinder: AssetFinder,
    val assetRemover: AssetRemover
) {
    fun appendAsset(type: AssetType, user: User): Long {
        return assetAppender.append(type, user)
    }

    fun findAsset(assetId: Long): Asset {
        return assetFinder.find(assetId)
    }

    fun deleteAsset(assetId: Long, user: User): Any {
        return assetRemover.remove(assetId, user)
    }
}

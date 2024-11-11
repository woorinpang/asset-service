package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.user.User
import org.springframework.stereotype.Component

@Component
class AssetRemover(
    val assetRepository: AssetRepository,
) {
    fun remove(target: AssetTarget, user: User) {
        assetRepository.removeAsset(target.id, user)
    }
}

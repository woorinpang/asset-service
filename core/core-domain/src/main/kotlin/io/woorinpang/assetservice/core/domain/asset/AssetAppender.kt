package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.core.enums.AssetType
import org.springframework.stereotype.Component

@Component
class AssetAppender(
    val assetRepository: AssetRepository,
) {
    fun append(user: User, type: AssetType): Long = assetRepository.append(user.id, type, user.email)
}

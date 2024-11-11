package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.enums.AssetType

data class AssetTargetWithType(
    val id: Long,
    val type: AssetType,
)

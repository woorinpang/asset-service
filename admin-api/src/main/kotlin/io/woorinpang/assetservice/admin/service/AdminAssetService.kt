package io.woorinpang.assetservice.admin.service

import io.woorinpang.assetservice.storage.db.core.asset.AdminAssetEntityQueryRepository
import org.springframework.stereotype.Service

@Service
class AdminAssetService(
    val adminAssetEntityQueryRepository: AdminAssetEntityQueryRepository,
)

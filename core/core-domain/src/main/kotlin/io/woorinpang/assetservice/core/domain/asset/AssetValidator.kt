package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntityJpaRepository
import org.springframework.stereotype.Component

@Component
class AssetValidator(
    val assetEntityJpaRepository: ElectronicDeviceEntityJpaRepository
) {

}
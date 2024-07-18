package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntity
import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntityJpaRepository

object ElectronicDeviceHelper {
    fun append(repository: ElectronicDeviceEntityJpaRepository, entity: ElectronicDeviceEntity): ElectronicDeviceEntity {
        return repository.save(entity)
    }
}
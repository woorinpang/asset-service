package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.support.error.CoreDomainException
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorType
import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntity
import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntityJpaRepository

object ElectronicDeviceHelper {
    fun findElectronicDeviceById(
        repository: ElectronicDeviceEntityJpaRepository,
        id: Long,
    ): ElectronicDeviceEntity {
        return repository
            .findById(id)
            .orElseThrow { CoreDomainException(DomainErrorType.ELECTRONIC_DEVICE_NOT_FOUND) }
    }
}

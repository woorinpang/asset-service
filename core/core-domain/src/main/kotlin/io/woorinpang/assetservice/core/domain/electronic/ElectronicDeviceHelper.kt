package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.support.error.CoreDomainException
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorType

object ElectronicDeviceHelper {
    fun findElectronicDeviceById(
        repository: ElectronicDeviceRepository,
        id: Long,
    ): ElectronicDevice = repository.findElectronicDevice(id)
        ?: throw CoreDomainException(DomainErrorType.ELECTRONIC_DEVICE_NOT_FOUND)
}

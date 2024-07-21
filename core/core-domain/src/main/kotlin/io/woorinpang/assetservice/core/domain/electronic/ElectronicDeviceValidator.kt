package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.support.error.CoreDomainException
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorType
import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntityJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ElectronicDeviceValidator(
    val electronicDeviceEntityJpaRepository: ElectronicDeviceEntityJpaRepository
) {
    @Transactional(readOnly = true)
    fun validCreatedBy(target: ElectronicDeviceTarget, user: User) {
        ElectronicDeviceHelper
            .findElectronicDeviceById(electronicDeviceEntityJpaRepository, target.id)
            .equalCreatedBy(user.email)
            .takeIf { it}
            ?: throw CoreDomainException(DomainErrorType.ELECTRONIC_DEVICE_CREATED_BY_NOT_EQUAL)
    }
}

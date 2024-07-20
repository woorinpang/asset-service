package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntityJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ElectronicDeviceRemover(
    val electronicDeviceEntityJpaRepository: ElectronicDeviceEntityJpaRepository
) {
    @Transactional
    fun remove(
        target: ElectronicDeviceTarget,
        user: User
    ) {
        ElectronicDeviceHelper
            .findElectronicDeviceById(electronicDeviceEntityJpaRepository, target.id)
            .delete(user.email)
    }
}
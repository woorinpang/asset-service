package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntityJpaRepository
import org.springframework.stereotype.Component

@Component
class ElectronicDeviceValidator(
    val electronicDeviceEntityJpaRepository: ElectronicDeviceEntityJpaRepository
) {
    fun verifyCreateBy(target: ElectronicDeviceTarget) {
        val findElectronicDevice =
            ElectronicDeviceHelper.findElectronicDeviceById(electronicDeviceEntityJpaRepository, target.id)


    }

}

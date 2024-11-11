package io.woorinpang.assetservice.storage.db.core.electronic

import io.woorinpang.assetservice.core.domain.electronic.ElectronicDevice
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceRepository
import io.woorinpang.assetservice.core.domain.electronic.ElectronicDeviceType
import io.woorinpang.assetservice.core.domain.user.User
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class ElectronicDeviceEntityRepository(
    val electronicDeviceEntityJpaRepository: ElectronicDeviceEntityJpaRepository,
) : ElectronicDeviceRepository {
    @Transactional
    override fun append(
        assetId: Long,
        type: ElectronicDeviceType,
        electronicDevice: ElectronicDevice,
        user: User
    ): Long {
        val electronicDeviceEntity = ElectronicDeviceEntity.of(
            assetId = assetId,
            type = type,
            manufacturer = electronicDevice.manufacturer,
            model = electronicDevice.model,
            serialNumber = electronicDevice.serialNumber!!,
            price = electronicDevice.price.value,
            createdBy = user.email,
        )
        return electronicDeviceEntityJpaRepository.save(electronicDeviceEntity).id
    }

    @Transactional
    override fun removeElectronicDevice(electronicDeviceId: Long, user: User) {
        electronicDeviceEntityJpaRepository.findByIdOrNull(electronicDeviceId)?.delete(user.email)
    }

    override fun modifyElectronicDevice(electronicDeviceId: Long, user: User, electronicDevice: ElectronicDevice) {
        electronicDeviceEntityJpaRepository.findByIdOrNull(electronicDeviceId)?.modify(
            electronicDevice.manufacturer,
            electronicDevice.model!!,
            electronicDevice.serialNumber!!,
            electronicDevice.price.value,
            user.email,
        )
    }

    override fun findElectronicDevice(electronicDeviceId: Long): ElectronicDevice? {
        return electronicDeviceEntityJpaRepository.findByIdOrNull(electronicDeviceId)?.let {
            ElectronicDevice.of(
                it.manufacturer,
                it.model,
                it.serialNumber,
                it.price,
            )
        }
    }
}

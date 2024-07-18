package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntity
import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntityJpaRepository
import io.woorinpang.assetservice.storage.db.core.electronic.PersonalComputerEntity
import io.woorinpang.assetservice.storage.db.core.electronic.PersonalComputerEntityJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class PersonalComputerAppender(
    val electronicDeviceEntityJpaRepository: ElectronicDeviceEntityJpaRepository,
    val personalComputerEntityJpaRepository: PersonalComputerEntityJpaRepository,
) {
    @Transactional
    fun append(
        target: ElectronicDeviceTarget,
        personalComputer: PersonalComputer
        ): Long {
        val electronicDeviceEntity = electronicDeviceEntityJpaRepository
            .findByAssetIdAndType(target.assetId, target.type.name)
            ?: ElectronicDeviceHelper.append(electronicDeviceEntityJpaRepository, ElectronicDeviceEntity(target.assetId, target.type.name))
        val personalComputerEntity = PersonalComputerEntity.of(electronicDeviceEntity.id!!, personalComputer)
        return personalComputerEntityJpaRepository.save(personalComputerEntity).id!!;
    }
}